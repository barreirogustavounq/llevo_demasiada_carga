package LlevoDemasiadaCarga

abstract class Item(val nombre: String, var volumen: Int) {

  def usar(personaje : Personaje)
}
