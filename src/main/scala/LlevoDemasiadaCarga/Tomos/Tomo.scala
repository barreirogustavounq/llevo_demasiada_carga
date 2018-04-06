package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga._

abstract class Tomo(nombreTomo : String, volumenTomo : Int) extends Item(nombreTomo, volumenTomo) with Usable
{
  var usos : Int
  override def usar()
  def puedeUsar()= usos > 0
  override def efecto(personaje: Personaje)
}
