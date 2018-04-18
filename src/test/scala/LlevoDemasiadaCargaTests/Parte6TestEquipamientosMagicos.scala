package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Equipables.ItemsEquipables.{ArmaduraEngarzable, Cinturon, EspadaCorta}
import LlevoDemasiadaCarga.EquipamientoMagico.ItemsMagicos.{ArmaduraEngarzableMagica, EspadaCortaMagica}
import LlevoDemasiadaCarga.EquipamientoMagico.Pergamino
import LlevoDemasiadaCarga.Excepciones.NoIdentificadoException
import LlevoDemasiadaCarga.Rareza.{MuyRaro, Raro, Unico}
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte6TestEquipamientosMagicos extends FunSuite with BeforeAndAfter {
  val inventario:Inventario = new Inventario(20)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  var espadaMagica: EspadaCortaMagica = new EspadaCortaMagica
  var armaduraEngarzableMagica: ArmaduraEngarzableMagica = new ArmaduraEngarzableMagica
  var pergamino1:Pergamino = new Pergamino
  var pergamino2:Pergamino = new Pergamino

  before{
    this.personaje.recogerItem(this.espadaMagica)
    this.personaje.recogerItem(this.pergamino1)
    this.personaje.recogerItem(this.pergamino2)

    this.personaje.status.fuerza = 30
  }


  test("NoSePuedeEquiparUnaEspadaMagicaQueNoEstaIdentificada") {
    assertThrows[NoIdentificadoException]{this.personaje.equiparItem(this.espadaMagica)}
  }

  test("SeIdentificaUnaEspadaMagicaYDejaEquiparla") {
    assert(!this.personaje.equipo.manoDerecha.estaEquipado())

    this.personaje.identificarItem(this.espadaMagica, this.pergamino1)
    this.personaje.equiparItem(this.espadaMagica)

    assert(this.personaje.equipo.manoDerecha.estaEquipado())
  }

  test("SeIdentificaUnaEspadaMagicaYElPergaminoDesapareceDelInventario"){
    assert(this.personaje.tieneItemEnInventario(this.pergamino1))

    this.personaje.identificarItem(this.espadaMagica, this.pergamino1)

    assert(!this.personaje.tieneItemEnInventario(this.pergamino1))
  }

  test("EspadaMagicaTieneComoEfectoMagicoDisminuidoSuVolumenCuandoSeIdentifica") {
    assert(this.espadaMagica.volumen == 4)

    this.personaje.identificarItem(this.espadaMagica, this.pergamino1)

    assert(this.espadaMagica.volumen == 1)
  }


  test("ElPersonajeRecojeUnaArmaduraQueSoloConTenerlaSubeSuSuerteCuandoLaIdentificas") {
    assert(personaje.status.suerte == 0)
    this.personaje.recogerItem(this.armaduraEngarzableMagica)
    assert(personaje.status.suerte == 0)

    this.personaje.identificarItem(this.armaduraEngarzableMagica, this.pergamino1)

    assert(this.personaje.status.suerte == 20)
  }

  test("ElPersonajeTiraUnaArmaduraQueAumentaSuSuerteYEstaUltimaDisminuye") {
    this.personaje.recogerItem(this.armaduraEngarzableMagica)
    this.personaje.identificarItem(this.armaduraEngarzableMagica, this.pergamino1)
    assert(this.personaje.status.suerte == 20)

    this.personaje.tirarItem(this.armaduraEngarzableMagica)

    assert(this.personaje.status.suerte == 0)
    assert(!this.personaje.tieneItemEnInventario(this.armaduraEngarzableMagica))
  }

  // * Rarezas
  test("UnaEspadaMagicaRaraValeElDobleQueUnaComun") {
    var espadaCorta = new EspadaCorta()
    var espadaCortaMagicaRara = new EspadaCortaMagica with Raro

    assert(espadaCortaMagicaRara.calcularPrecioCompra() == (espadaCorta.calcularPrecioCompra() * 2))
    assert(espadaCortaMagicaRara.calcularPrecioVenta() == (espadaCorta.calcularPrecioVenta() * 2))
  }
  test("UnGuanteMuyRaroValeElTripleQueUnoComun") {
    var espadaCorta = new EspadaCorta()
    var espadaCortaMagicaMuyRara = new EspadaCortaMagica with MuyRaro

    assert(espadaCortaMagicaMuyRara.calcularPrecioCompra() == (espadaCorta.calcularPrecioCompra() * 3))
    assert(espadaCortaMagicaMuyRara.calcularPrecioVenta() == (espadaCorta.calcularPrecioVenta() * 3))
  }
  test("UnaArmaduraUnicaValeElQuintupleQueUnoComun") {
    var espadaCorta = new EspadaCorta()
    var espadaCortaMagicaMuyUnica = new EspadaCortaMagica with Unico

    assert(espadaCortaMagicaMuyUnica.calcularPrecioCompra() == (espadaCorta.calcularPrecioCompra() * 5))
    assert(espadaCortaMagicaMuyUnica.calcularPrecioVenta() == (espadaCorta.calcularPrecioVenta() * 5))
  }

}
