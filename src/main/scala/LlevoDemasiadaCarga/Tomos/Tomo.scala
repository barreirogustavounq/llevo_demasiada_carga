package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga._

abstract class Tomo(nombreTomo : String, volumenTomo : Int) extends Usable(nombreTomo, volumenTomo) {
  var usos : Int
  override def usar(personaje: Personaje)
  def puedeUsar(): Boolean = usos > 0
}
