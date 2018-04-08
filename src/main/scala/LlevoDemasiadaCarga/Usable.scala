package LlevoDemasiadaCarga

class Usable(nombre: String, volumen: Int) extends Item(nombre, volumen) {
  override def usar(personaje: Personaje): Unit = { }
}
