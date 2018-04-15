package LlevoDemasiadaCarga

import scala.collection.mutable

trait Equipable
{
  val lugarDondeSeEquipa : String
  val requerimientos : mutable.Set[Atributo] = mutable.Set()
  val efectos : Efecto

}
