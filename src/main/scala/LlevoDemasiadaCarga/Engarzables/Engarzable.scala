package LlevoDemasiadaCarga.Engarzables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Excepciones.CantidadDeEngarzesAlMaximo
import LlevoDemasiadaCarga.{ItemBasico, Personaje}

import scala.collection.mutable

trait Engarzable extends Equipable{
  var cantidadEngarzes:Int
  val engarzes: mutable.Set[Engarze] = mutable.Set()
  val efectosExtras:EfectosExtras = new EfectosExtras

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

  override def equipar(personaje: Personaje):Unit={
    this.engarzes.foreach(e => e.aplicar(personaje))
    this.efectosExtras.aplicarEfectosExtras(this.engarzes, personaje)
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje):Unit={
    this.engarzes.foreach(e => e.deshacer(personaje))
    this.efectosExtras.deshacerEfectosExtras(this.engarzes, personaje)
    super.desequipar(personaje)
  }

  def tieneEngarze(engarze: Engarze): Boolean = this.engarzes.contains(engarze)
}
