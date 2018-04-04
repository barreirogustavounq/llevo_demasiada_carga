package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga._
import org.scalatest.FunSuite

class Parte2Test extends FunSuite {
  // Setup Personaje
  val inventario:Inventario = new Inventario(10)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario)
  val cinturon:Cinturon = new Cinturon(3, inventario)
  this.inventario.cinturon = this.cinturon
  this.inventario.personaje = this.personaje

  // Setup Vendedor
  val arco:Item = new Item(10)
  val inventarioVendedor: Inventario = new Inventario(20)
  this.inventarioVendedor.recogerItem(arco)
  val vendedor:Vendedor = new Vendedor(inventarioVendedor)

  test("ComprarUnArcoAlVendedor"){
    personaje.comprar(arco, vendedor)

    assert(personaje.oro == 0)
    assert(vendedor.items.isEmpty)
  }
}
