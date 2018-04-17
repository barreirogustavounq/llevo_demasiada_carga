package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Cinturon, Inventario, Personaje, Vendedor}
import org.scalatest.FunSuite

class Parte5TestEquipamientosEngarzables extends FunSuite {

  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  test("")
  /*
  Modelar el equipamiento engarzable, permitiendo:
  ● Engarzar un una gema en un ítem
  ● Engarzar runas en un ítem, permitiendo las combinaciones.
  ● Equiparlos y desequiparlos
  ● Aquello que se puede hacer con un equipable común
   */

}
