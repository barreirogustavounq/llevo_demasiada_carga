package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.Efecto

import scala.collection.mutable

class TipoDeItem( val volumen: Int,
                  val lugarDeEquipamiento: String,
                  val efecto: mutable.Set[Efecto],
                  val requerimientos: mutable.Set[Atributo] ) {

}
