package LlevoDemasiadaCarga

abstract class Item {
  val volumen: Int
  def usar(personaje: Personaje): Unit
}
