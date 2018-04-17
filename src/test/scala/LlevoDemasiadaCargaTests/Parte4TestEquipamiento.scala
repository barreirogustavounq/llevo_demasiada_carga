package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Equipables.ItemsEquipables.{ArmaduraCuero, CascoVikingo, EspadaCorta}
import LlevoDemasiadaCarga.Excepciones.{NoCumpleRequerimientosException, NoSePuedeEquiparException}
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte4TestEquipamiento extends FunSuite with BeforeAndAfter {

  // Setup Personaje
  var inventario:Inventario = new Inventario(30)
  var cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  var personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  // Setup Items Equipables
  var cascoVikingo1: CascoVikingo = new CascoVikingo
  var cascoVikingo2: CascoVikingo = new CascoVikingo
  var armaduraCuero: ArmaduraCuero = new ArmaduraCuero
  var espadaCorta: EspadaCorta = new EspadaCorta


  before {
    this.personaje.recogerItem(this.cascoVikingo1)
    this.personaje.recogerItem(this.cascoVikingo2)
    this.personaje.recogerItem(this.armaduraCuero)
    this.personaje.recogerItem(this.espadaCorta)

    //Seteamos algunos parametros del status del personaje
    this.personaje.status.agilidad = 30
    this.personaje.status.fuerza = 30
  }


  // Casos Positivos

  test("AlEquiparUnCascoApareceEnElSlotCorrespondiente") {
    assert(!this.personaje.equipo.casco.estaEquipado())

    this.personaje.equiparItem(cascoVikingo1)

    assert(this.personaje.equipo.casco.estaEquipado())
    assert(this.personaje.equipo.casco.itemEquipado == this.cascoVikingo1)
  }

  test("AlDesequiparUnCascoDesapareceDelSlotCorrespondiente") {
    this.personaje.equiparItem(this.cascoVikingo1)
    assert(this.personaje.equipo.casco.itemEquipado == this.cascoVikingo1)

    this.personaje.desequiparItem(this.cascoVikingo1)

    assert(!this.personaje.equipo.casco.estaEquipado())
  }

  test("AlEquiparUnCascoNoApareceEnElInventario") {
    assert(this.personaje.tieneItemEnInventario(this.cascoVikingo1))

    this.personaje.equiparItem(this.cascoVikingo1)

    assert(!this.personaje.tieneItemEnInventario(cascoVikingo1))
  }

  test("AlEquiparUnCascoSusEfectosAfectanAlPersonaje") {
    assert(this.personaje.status.defensa == 0)

    this.personaje.equiparItem(this.cascoVikingo1)

    assert(this.personaje.status.defensa == 5)
  }

  test("AlDesequiparUnCascoSeDeshacenSusEfectos") {
    this.personaje.equiparItem(this.cascoVikingo1)
    assert(this.personaje.status.defensa == 5)

    this.personaje.desequiparItem(this.cascoVikingo1)

    assert(this.personaje.status.defensa == 0)
  }

  test("AlDesequiparUnCascoApareceEnElInventario") {
    this.personaje.equiparItem(this.cascoVikingo1)
    assert(!this.personaje.tieneItemEnInventario(this.cascoVikingo1))

    this.personaje.desequiparItem(this.cascoVikingo1)
    assert(this.personaje.tieneItemEnInventario(this.cascoVikingo1))
  }

  test("AlTirarUnCascoEquipadoDesapareceDelSlotCorrespondiente") {
    this.personaje.equiparItem(this.cascoVikingo1)
    assert(this.personaje.equipo.casco.estaEquipado())

    this.personaje.tirarItemEquipado(this.cascoVikingo1)

    assert(!this.personaje.equipo.casco.estaEquipado())
  }

  test("AlTirarUnCascoEquipadoNoApareceEnElInventario") {
    this.personaje.equiparItem(this.cascoVikingo1)

    this.personaje.tirarItemEquipado(this.cascoVikingo1)

    assert(!this.personaje.tieneItemEnInventario(this.cascoVikingo1))
  }

  test("AlTirarUnCascoEquipadoSeDeshacenSusEfectos") {
    this.personaje.equiparItem(this.cascoVikingo1)

    this.personaje.tirarItemEquipado(this.cascoVikingo1)

    assert(this.personaje.status.defensa == 0)
  }

  // Casos Negativos

  test("PersonajeNoPuedeEquiparCascoPorqueNoCumpleRequisitos"){
    this.personaje.status.agilidad = 0

    assertThrows[NoCumpleRequerimientosException] {this.personaje.equiparItem(this.cascoVikingo1)}
    assert(!this.personaje.equipo.casco.estaEquipado())
    assert(this.personaje.status.defensa == 0)
    assert(this.personaje.tieneItemEnInventario(this.cascoVikingo1))
  }

  test("PersonajeNoPuedeEquiparUnCascoSiYaTieneUnoEquipado"){
    this.personaje.equiparItem(this.cascoVikingo2)
    assert(this.personaje.equipo.casco.estaEquipado())
    assert(this.personaje.equipo.casco.itemEquipado == this.cascoVikingo2)

    assertThrows[NoSePuedeEquiparException]{this.personaje.equiparItem(this.cascoVikingo1)}
  }

}
