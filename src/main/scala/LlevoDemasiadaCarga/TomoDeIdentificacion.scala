package LlevoDemasiadaCarga

class TomoDeIdentificacion(nombreTomo : String, volumenTomo : Int) extends Tomo(nombreTomo, volumenTomo) {
  override var usos: Int = _

  override def usar(): Unit = ???

  override def efecto(personaje: Personaje): Unit = ???
}
