package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte1TestTirarYRecoger extends FunSuite with BeforeAndAfter {

  // SETUP
  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 0, cinturon)
  val casco: ItemBasico = new ItemBasico("casco",11)
  val medalla: ItemBasico = new ItemBasico("medalla",5)
  val medallaDePlata: ItemBasico = new ItemBasico("medalla de plata", 5)
  val stream = new java.io.ByteArrayOutputStream()

  // Limpia el inventario entre cada Test.
  after{
    inventario.items.clear()
    stream.reset()
  }

  // TESTING

  test("ElInventarioPuedeAgregarUnItem") {
    this.inventario.recogerItem(medalla)

    assert(this.inventario.tieneItem(this.medalla))
  }

  test("ElInventarioNoPuedeAgregarUnItemPorFaltaDeCapacidad"){
    Console.withOut(stream) { this.inventario.recogerItem(casco) }

    assertResult("No tienes suficiente espacio en el inventario.\n")(stream.toString)
    assert(this.inventario.items.isEmpty)
  }

  test("SeTiraUnItemDeUnInventarioCon1SoloItemYQuedaVacioConElEspacioLiberado") {
    this.inventario.recogerItem(medallaDePlata)
    this.inventario.tirarItem(this.medallaDePlata)

    assert(this.inventario.items.isEmpty)
    assert(this.inventario.volumenDisponible() == 10)
  }

  test("SeTiraUnItemQueNoSeEncuentraEnElInventarioYManejaLaExcepcionImprimiendoEnPantalla"){
    Console.withOut(stream) { this.inventario.tirarItem(this.medallaDePlata) }

    assertResult("No se encuentra el Item Espada Bastarda a tirar.\n")(stream.toString)
  }

}
