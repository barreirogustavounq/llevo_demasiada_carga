package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Engarzables.ItemsEngarzables.{Ruby, RunaMO, RunaRO}
import LlevoDemasiadaCarga.Equipables.ItemsEquipables.{ArmaduraEngarzable, Cinturon}
import LlevoDemasiadaCarga.Excepciones.CantidadDeEngarzesAlMaximo
import LlevoDemasiadaCarga.{Inventario, Personaje, Vendedor}
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte5TestEquipamientoEngarzable extends FunSuite with BeforeAndAfter {

  val inventario: Inventario = new Inventario(20)
  val cinturon: Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje: Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  var armaduraEngarzable: ArmaduraEngarzable = new ArmaduraEngarzable
  var ruby: Ruby = new Ruby
  var runaMO: RunaMO = new RunaMO
  var runaRO: RunaRO = new RunaRO

  before {
    this.personaje.recogerItem(this.armaduraEngarzable)
    this.personaje.recogerItem(this.ruby)
    this.personaje.recogerItem(this.runaMO)
    this.personaje.recogerItem(this.runaRO)

  }

  /* GEMAS */

  test("SeEngarzaUnaGemaYEstaApareceEnElItemEngarzable") {
    this.armaduraEngarzable.engarzar(this.ruby, this.personaje)

    assert(this.armaduraEngarzable.tieneEngarze(this.ruby))
  }

  test("SeEngarzaUnaGemaYEstaDesapareceDelInventario") {
    this.armaduraEngarzable.engarzar(this.ruby, this.personaje)

    assert(!this.personaje.tieneItemEnInventario(this.ruby))
  }

  test("SeEngarzaUnaGemaYSusEfectosAfectanAlPersonajeAlEquiparElItem") {
    this.armaduraEngarzable.engarzar(this.ruby, this.personaje)
    assert(this.personaje.vidaMaxima == 100)

    this.personaje.equiparItem(this.armaduraEngarzable)

    assert(this.personaje.vidaMaxima == 200)
  }

  test("SeQuiereEngarzarUnaGemaEnUnEngarzableQueAlcanzoElMaximoYLanzaExcepsion") {
    var ruby2: Ruby = new Ruby
    var ruby3: Ruby = new Ruby
    var ruby4: Ruby = new Ruby
    this.armaduraEngarzable.engarzar(this.ruby, this.personaje)
    this.armaduraEngarzable.engarzar(ruby2, this.personaje)
    this.armaduraEngarzable.engarzar(ruby3, this.personaje)

    assertThrows[CantidadDeEngarzesAlMaximo] {
      this.armaduraEngarzable.engarzar(ruby4, this.personaje)
    }
  }

  /* RUNAS */

  test("SeEngarzaUnaRunaYEstaApareceEnElItemEngarzable") {
    assert(!this.armaduraEngarzable.tieneEngarze(this.runaRO))
    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)

    assert(this.armaduraEngarzable.tieneEngarze(this.runaRO))
  }

  test("SeEngarzaUnaRunaYEstaDesapareceDelInventario") {
    assert(this.personaje.tieneItemEnInventario(this.runaRO))
    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)

    assert(!this.personaje.tieneItemEnInventario(this.runaRO))
  }

  test("SeEngarzaUnaRunaYSusEfectosAfectanAlPersonaje") {
    assert(personaje.vidaMaxima == 100)
    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)

    this.personaje.equiparItem(this.armaduraEngarzable)

    assert(this.personaje.vidaMaxima == 200)
  }

  test("SeQuiereEngarzarUnaRunaEnUnEngarzableQueAlcanzoElMaximoYLanzaExcepsion") {
    var runaRO2: RunaRO = new RunaRO
    var runaRO3: RunaRO = new RunaRO
    var runaRO4: RunaRO = new RunaRO
    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)
    this.armaduraEngarzable.engarzar(runaRO2, this.personaje)
    this.armaduraEngarzable.engarzar(runaRO3, this.personaje)

    assertThrows[CantidadDeEngarzesAlMaximo] {
      this.armaduraEngarzable.engarzar(runaRO4, this.personaje)
    }
  }

  test("SeEngarzaUnaRunaROConUnaRunaMOYDanMasDefensaYEfectoExtra") {
    assert(this.personaje.vidaMaxima == 100)
    assert(this.personaje.status.fuerza == 0)
    assert(this.personaje.status.defensa == 0)

    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)
    this.armaduraEngarzable.engarzar(this.runaMO, this.personaje)
    this.personaje.equiparItem(this.armaduraEngarzable)

    assert(this.personaje.vidaMaxima == 200)
    assert(this.personaje.status.fuerza == 10)
    assert(this.personaje.status.defensa == 30)
  }

  test("SeDesequipaItemsConRunasYEfectosExtrasYSeBajanLosStatsDelPersonaje") {
    this.armaduraEngarzable.engarzar(this.runaRO, this.personaje)
    this.armaduraEngarzable.engarzar(this.runaMO, this.personaje)
    this.personaje.equiparItem(this.armaduraEngarzable)
    assert(this.personaje.vidaMaxima == 200)
    assert(this.personaje.status.fuerza == 10)
    assert(this.personaje.status.defensa == 30)

    this.personaje.desequiparItem(this.armaduraEngarzable)

    assert(this.personaje.vidaMaxima == 100)
    assert(this.personaje.status.fuerza == 0)
    assert(this.personaje.status.defensa == 0)
  }
}
