package LlevoDemasiadaCarga.Engarzables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Excepciones.CantidadDeEngarzesAlMaximo
import LlevoDemasiadaCarga.{ItemBasico, Personaje}

import scala.collection.mutable

trait Engarzable extends Equipable{
  var cantidadEngarzes:Int
  val engarzes: mutable.Set[Engarze] = mutable.Set()

  def engarzar(engarze: Engarze, personaje: Personaje):Unit={
    this.puedeEngarzar()
    personaje.tirarItem(engarze)
    this.engarzes += engarze
  }

  def desenganzar(engarze: Engarze, personaje: Personaje):Unit={
    personaje.recogerItem(engarze)
    this.engarzes -= engarze
  }

  def puedeEngarzar():Unit= if(this.engarzes.size == cantidadEngarzes) throw CantidadDeEngarzesAlMaximo()

  def equipar(personaje: Personaje):Unit={
    this.engarzes.foreach(e => e.aplicar(personaje))
    /* super.equipar(personaje) -----TIENE QUE ESTAR IMPLEMENTADO EN EQUIPABLE Y SE ACCIONA CUANDO SE EQUIPA UN ITEM -----*/
  }

  def desequipar(personaje: Personaje):Unit={
    this.engarzes.foreach(e => e.deshacer(personaje))
    /* super.desequipar(personaje) -----TIENE QUE ESTAR IMPLEMENTADO EN EQUIPABLE Y SE ACCIONA CUANDO SE DESEQUIPA UN ITEM -----*/
  }
}
