package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte2TestComprarYVender extends FunSuite with BeforeAndAfter {
    val stream = new java.io.ByteArrayOutputStream()

    // Setup Personaje
    var inventario: Inventario = new Inventario(10)
    var cinturon: Cinturon = new Cinturon("Cinturon de Cuero", 3)
    var personaje: Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 15, cinturon)

    // Setup Item Comerciable
    def arco: Comerciable = new ItemBasico("Arco Largo", 5) with Comerciable {
        override val precioVenta: Int = 4
        override val precioCompra: Int = 15
      }

    // Setup Vendedor
    var inventarioVendedor: Inventario = new Inventario(20)
    var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  before{
    this.inventarioVendedor.recogerItem(this.arco)
  }


  after{
    personaje.oro = 15
    vendedor.inventario.items.clear()
    personaje.inventario.items.clear()
    stream.reset()
  }

  // TESTING

  test("ComprarUnArcoAlVendedor"){
    //vendedor.inventario.recogerItem(arco)
    //assert(vendedor.inventario.tieneItem(arco))
    //personaje.comprar(arco, vendedor)
    //assert(personaje.oro.equals(0))
    //assert(vendedor.inventario.items.isEmpty)
    //assert(personaje.inventario.tieneItem(arco))
  }
/*
  test("VenderUnArcoAlVendedor"){
    personaje.vender(arco, vendedor)
    assert(personaje.oro.equals(19))
    assert(personaje.inventario.items.isEmpty)
    assert(vendedor.inventario.tieneItem(arco))
  }

  test("ComprarUnArcoYQueLaTransaccionNoOcurraPorFaltaDeOroYLoInformeEnPantalla"){
    personaje.oro = 0
    Console.withOut(stream) { personaje.comprar(arco, vendedor) }
    assertResult("No tienes suficiente oro.\n")(stream.toString)

    assert(personaje.inventario.items.isEmpty)
    assert(vendedor.inventario.tieneItem(arco))
  }

  test("ComprarUnArcoYQueLaTransaccionNoOcurraPorFaltaDeEspacioYLoInformeEnPantalla"){
    var roca:Item = new ItemBasico("Roca", 10)
    personaje.recogerItem(roca)
    Console.withOut(stream) { personaje.comprar(arco, vendedor) }

    assertResult("No tienes suficiente espacio en el inventario.\n")(stream.toString)
    assert(personaje.inventario.items.isEmpty)
    assert(vendedor.inventario.tieneItem(arco))
  }
*/
}
