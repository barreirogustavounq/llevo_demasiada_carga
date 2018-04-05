package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Cinturon, Inventario, Item, Personaje}
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte1Test extends FunSuite with BeforeAndAfter {

  // SETUP
  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 0, cinturon)
  val casco: Item = new Item("casco",11)
  val medalla: Item = new Item("medalla",5)
  val medallaDePlata: Item = new Item("medalla de plata", 5)
  val stream = new java.io.ByteArrayOutputStream()

  // Limpia el inventario entre cada Test.
  after{
    inventario.items.clear()
    stream.reset()
  }

  // TESTING

  test("ElInventarioPuedeAgregarUnItem") {
    this.inventario.recogerItem(medalla)

    assert(this.inventario.items.exists(_.nombre == "medalla"))
  }

  test("ElInventarioNoPuedeAgregarUnItemPorFaltaDeCapacidad"){
    Console.withOut(stream) { this.inventario.recogerItem(casco) }

    assertResult("No tienes suficiente espacio en el inventario.\n")(stream.toString)
    assert(this.inventario.items.isEmpty)
  }

  test("SeTiraUnItemDeUnInventarioCon1SoloItemYQuedaVacioConElEspacioLiberado") {
    this.inventario.recogerItem(medallaDePlata)
    this.inventario.tirarItem(medallaDePlata.nombre)

    assert(this.inventario.items.isEmpty)
  }

  test("SeTiraUnItemQueNoSeEncuentraEnElInventarioYManejaLaExcepcionImprimiendoEnPantalla"){
    Console.withOut(stream) { this.inventario.tirarItem("Espada Bastarda") }

    assertResult("No se encontro el Item Espada Bastarda a tirar.\n")(stream.toString)
  }

}
