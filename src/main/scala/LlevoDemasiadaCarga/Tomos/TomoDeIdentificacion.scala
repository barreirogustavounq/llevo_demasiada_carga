package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga.Personaje

class TomoDeIdentificacion(nombreTomo : String, volumenTomo : Int) extends Tomo(nombreTomo, volumenTomo) {
  override var usos: Int = _

  override def usar(personaje : Personaje): Unit = {}

}
