package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Cinturon, Inventario, Item, Personaje}
import org.scalatest.FunSuite

class Parte1Test extends FunSuite {

  val inventario:Inventario = new Inventario(10)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario)
  val cinturon:Cinturon = new Cinturon(3, inventario)

  this.inventario.cinturon = this.cinturon
  this.inventario.personaje = this.personaje



  test("ElInventarioPuedeAgregarUnItem") {
    val item: Item = new Item(5)

    this.inventario.recogerItem(item)

    assert(this.inventario.items.size == 1)
  }

  test("ElInventarioNoPuedeAgregarUnItemPorFaltaDeCapacidad"){
    val item: Item = new Item(11)

    this.inventario.recogerItem(item)

    assert(this.inventario.items.isEmpty)
  }

  test("SeTiraUnItemDeUnInventarioCon1SoloItemYQuedaVacioConElEspacioLiberado") {
    val item: Item = new Item(5)

    this.inventario.recogerItem(item)
    this.inventario.tirarItem(item)

    assert(this.inventario.items.isEmpty)
  }


}
