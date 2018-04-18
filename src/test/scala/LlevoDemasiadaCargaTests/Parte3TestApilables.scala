package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.EfectosUsables.EfectoVidaActual
import LlevoDemasiadaCarga.Equipables.ItemsEquipables.Cinturon
import LlevoDemasiadaCarga.Excepciones.{CantidadDeApilablesAlMaximoException, DiferenteTipoException}
import LlevoDemasiadaCarga.Pilas.Apilable
import LlevoDemasiadaCarga.Pilas.ItemsApilables.{Flecha, Saeta}
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable

class Parte3TestApilables extends FunSuite with BeforeAndAfter {




  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var flecha1: Flecha = new Flecha()
  var flecha2: Flecha = new Flecha()
  var flecha3: Flecha = new Flecha()
  var flecha4: Flecha = new Flecha()
  var flecha5: Flecha = new Flecha()
  var flecha6: Flecha = new Flecha()
  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  var saeta:Saeta = new Saeta

 before{
    vendedor.inventario.recogerItem(flecha4)
    vendedor.inventario.recogerItem(flecha5)
    vendedor.inventario.recogerItem(flecha6)

    this.personaje.recogerItem(flecha1)
    this.personaje.recogerItem(flecha2)
    this.personaje.recogerItem(flecha3)
  }

  // Reset de referencias entre las pilas.
  after {
    flecha1 = new Flecha
    flecha2 = new Flecha
    flecha3 = new Flecha
    flecha4 = new Flecha
    flecha5 = new Flecha
    flecha6 = new Flecha
    this.personaje.vidaActual = 100
    this.personaje.oro = 10
    this.personaje.inventario.tirarTodo()
    this.vendedor.inventario.tirarTodo()
  }

  /*CASOS POSITIVOS */

  test("Apilo3FlechasYPidoLaCantidadDeItems"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.flecha1.cantidadDeApilables() == 3)
  }

  test("AgregoTresFlechasYVeoElVolumenDeLaPila"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.flecha1.calcularVolumen() == 3)
  }

  test("UsoUnaPilaDe3FlechasCon1UsoCadaUnaYUnaDesaparece"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.flecha1.cantidadDeApilables() == 3)
    this.flecha1.usar(this.personaje)
    assert(this.flecha1.cantidadDeApilables() == 2)
  }

  test("UsoUnaPilaDe3FlechasYAlPersonajeSeLeModificaLaVidaActual"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.personaje.vidaActual == 100)
    this.flecha1.usar(this.personaje)
    assert(this.personaje.vidaActual == 110)
  }

  test("Saco1FlechaDeUnaPilaCon3Flechas"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.flecha1.cantidadDeApilables() == 3)
    var flecha = this.flecha1.desapilar()
    assert(this.flecha1.cantidadDeApilables() == 2)
  }

  /*------- Test de ventas -------*/

  test("VendoUnaPilaDe3FlechasYElPersonajeYaNoTieneLaPilaEnElInventario"){
    this.flecha1.apilar(this.flecha3, this.inventario)
    assert(this.personaje.inventario.tieneItem(this.flecha1))

    this.personaje.vender(this.flecha1, vendedor)
    assert(!this.personaje.tieneItemEnInventario(this.flecha1))
  }

  test("VendoUnaPilaDe3FlechasYAlPersonajeLeSubeLaCantidadDeOro"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)

    personaje.vender(this.flecha1, vendedor)
    assert(personaje.oro.equals(16))
  }

  test("VendoUnaPilaDe3FlechasYElVendedorTieneLaPilaEnSuInventario"){
    this.flecha1.apilar(this.flecha2, this.inventario)
    this.flecha1.apilar(this.flecha3, this.inventario)

    personaje.vender(this.flecha1, vendedor)
    assert(this.vendedor.inventario.tieneItem(this.flecha1))
  }

  /*------- Test de compras -------*/

  test("CompraUnaPilaDe3FlechasYElPersonajeTieneLaPilaEnElInventario"){
    flecha4.apilar(flecha5, this.vendedor.inventario)
    flecha4.apilar(flecha6, this.vendedor.inventario)

    personaje.comprar(flecha4, this.vendedor)

    assert(this.personaje.tieneItemEnInventario(flecha4))
  }

  test("CompraUnaPilaDe3FlechasYAlPersonajeLeBajaLaCantidadDeOro"){
    flecha4.apilar(flecha5, this.vendedor.inventario)
    flecha4.apilar(flecha6, this.vendedor.inventario)

    personaje.comprar(flecha4, this.vendedor)

    assert(this.personaje.oro == 7)
  }

  test("CompraUnaPilaDe3FlechasYElVendedorYaNoTieneLaPila"){
    flecha4.apilar(flecha5, this.vendedor.inventario)
    flecha4.apilar(flecha6, this.vendedor.inventario)

    personaje.comprar(flecha4, this.vendedor)

    assert(!this.vendedor.inventario.tieneItem(flecha4))
  }

  /* CASOS NEGATIVOS */

  test("NoSePuedeApilarUnaFlechaConUnaSaeta"){
    var flechaNueva:Flecha = new Flecha
    var saetaNueva:Saeta = new Saeta

    this.personaje.recogerItem(flechaNueva)
    this.personaje.recogerItem(saetaNueva)

    assertThrows[DiferenteTipoException] {
      flechaNueva.apilar(saetaNueva, this.personaje.inventario)
    }
  }

  test("NoSePuedenApilarMasDe5Flechas"){
    this.personaje.recogerItem(flecha4)
    this.personaje.recogerItem(flecha5)
    this.personaje.recogerItem(flecha6)

    this.flecha1.apilar(flecha2, this.personaje.inventario)
    this.flecha1.apilar(flecha3, this.personaje.inventario)
    this.flecha1.apilar(flecha4, this.personaje.inventario)
    this.flecha1.apilar(flecha5, this.personaje.inventario)

    assertThrows[CantidadDeApilablesAlMaximoException]{
      this.flecha1.apilar(flecha6, this.personaje.inventario)
    }
  }
}
