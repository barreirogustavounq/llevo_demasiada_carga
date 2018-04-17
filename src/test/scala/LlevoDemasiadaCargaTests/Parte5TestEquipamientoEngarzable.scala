package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Cinturon, Inventario, Personaje, Vendedor}
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte5TestEquipamientoEngarzable extends FunSuite with BeforeAndAfter {

  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)


  // Modelar el equipamiento engarzable, permitiendo:

  //  * Engarzar un una gema en un ítem

  test("SeEngarzaUnaGemaYEstaApareceEnElItemEngarzable") {}
  test("SeEngarzaUnaGemaYEstaDesapareceDelInventario") {}
  test("SeEngarzaUnaGemaYSusEfectosAfectanAlPersonaje") {}
  test("SeQuiereEngarzarUnaGemaEnUnEngarzableQueAlcanzoElMaximoYLanzaExcepsion") {}

  //  * Engarzar runas en un ítem, permitiendo las combinaciones.
  test("SeEngarzaUnaRunaYEstaApareceEnElItemEngarzable") {}
  test("SeEngarzaUnaRunaYEstaDesapareceDelInventario") {}
  test("SeEngarzaUnaRunaYSusEfectosAfectanAlPersonaje") {}
  test("SeQuiereEngarzarUnaRunaEnUnEngarzableQueAlcanzoElMaximoYLanzaExcepsion") {}
  test("SeEngarzaUnaRunaCaEnUnEngarzableConUnaRunaRoYHacenCombinacion") {}

  //  * Equiparlos y desequiparlos
  test("SeEquipaUnEngarzableConRunaYGemaYSusEfectosAfectanAlPersonaje") {}
  test("SeDesequipaUnEngarzableConRunaYGemaYSeDeshacenLosEfectosAlPersonaje") {}

  //  * Aquello que se puede hacer con un equipable común
  test("SeTiraUnEngarzableConRunaYGemaYSeDeshacenLosEfectosAlPersonaje") {}
}
