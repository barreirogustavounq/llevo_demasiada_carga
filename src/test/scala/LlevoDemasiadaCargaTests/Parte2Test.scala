package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Cinturon, Inventario, Item, Personaje}
import org.scalatest.FunSuite

class Parte2Test extends FunSuite {
    val inventario:Inventario = new Inventario(10)
    val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario)
    val cinturon:Cinturon = new Cinturon(3, inventario)
    val arco:Item = new Item(10)
    val vendedor:Vendedor = new Vendedor()
    this.inventario.cinturon = this.cinturon
    this.inventario.personaje = this.personaje


    test("ComprarUnArcoAlVendedor"){
        personaje.comprarAVendedor(arco, vendedor)

        assert(vendedor.oro == 15)
        assert(personaje.oro == 0)
        assert(vendedor.items.isEmpty)
    }
}
