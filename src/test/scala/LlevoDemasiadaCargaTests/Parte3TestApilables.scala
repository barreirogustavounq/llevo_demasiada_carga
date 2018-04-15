package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Efectos.EfectoVidaActual
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte3TestApilables extends FunSuite with BeforeAndAfter {
  class Flecha extends ItemBasico("Flecha", 2) with Comerciable with Consumible with EfectoVidaActual with Apilable{
    override val precioCompra: Int = 1
    override val precioVenta: Int = 2
    override var valorDeEfecto: Int = 10
    override var cantidadDeUsos: Int = 1
  }

  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 0, cinturon)

  val flecha1: Flecha = new Flecha
  val flecha2: Flecha = new Flecha
  val flecha3: Flecha = new Flecha

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)


  before{
    this.personaje.recogerItem(flecha1)
    this.personaje.recogerItem(flecha2)
    this.personaje.recogerItem(flecha3)
  }

/*CASOS POSITIVOS */

  test("Apilo3FlechasYPidoLaCantidadDeItems"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.flecha1.cantidadDeApilables() == 3)
  }

  test("AgregoTresFlechasYVeoElVolumenDeLaPila"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.flecha1.calcularVolumen() == 3)
  }

  test("UsoUnaPilaDe3FlechasCon1UsoCadaUnaYUnaDesaparece"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.flecha1.cantidadDeApilables() == 3)
    this.flecha1.usar(this.personaje)
    assert(this.flecha1.cantidadDeApilables() == 2)
  }

  test("UsoUnaPilaDe3FlechasYAlPersonajeSeLeModificaLaVidaActual"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.personaje.vidaActual == 100)
    this.flecha1.usar(this.personaje)
    assert(this.personaje.vidaActual == 110)
  }

  test("Saco1FlechaDeUnaPilaCon3Flechas"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.flecha1.cantidadDeApilables() == 3)
    var flecha = this.flecha1.desapilar()
    assert(this.flecha1.cantidadDeApilables() == 2)
  }

  test("VendoUnaPilaDe3FlechasYElPersonajeYaNoLosTieneEnInventario"){
    this.flecha1.apilar(this.flecha2)
    this.flecha1.apilar(this.flecha3)
    assert(this.personaje.tieneItem(flecha1))
    assert(this.personaje.tieneItem(flecha2))
    assert(this.personaje.tieneItem(flecha3))

    assert(flecha1.calcularPrecioVenta()==6)
    assert(flecha1.calcularPrecioCompra()==3)
    /*personaje.vender(this.flecha1, vendedor)
    assert(personaje.oro.equals(19))*/

  }






}
