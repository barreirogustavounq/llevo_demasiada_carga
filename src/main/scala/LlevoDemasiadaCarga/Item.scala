package LlevoDemasiadaCarga

abstract class Item(val nombre: String, val volumen: Int) {
  var esAlmacenadoEn : Inventario = _

  def guardarEn(inventario: Inventario): Unit = { this.esAlmacenadoEn = inventario }

  def tirar(): Unit = { this.esAlmacenadoEn = null }

  def usar(personaje : Personaje): Unit

}
