package LlevoDemasiadaCarga

import scala.collection.mutable


class Cinturon(var capacidadCinturon:Int) extends Inventario(capacidadCinturon) with Equipable {

  override var items = mutable.Set[Pocion]

}
