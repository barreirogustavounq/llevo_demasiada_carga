package LlevoDemasiadaCarga.Engarzables

import LlevoDemasiadaCarga.Engarzables.ItemsEngarzables.{RunaMO, RunaRO}
import LlevoDemasiadaCarga.Personaje

import scala.collection.mutable

class EfectosExtras {
  def aplicarEfectosExtras(engarzes:mutable.Set[Engarze], personaje: Personaje):Unit={
    if (engarzes.exists(_.isInstanceOf[RunaRO] && engarzes.exists(_.isInstanceOf[RunaMO]))) personaje.status.defensa += 10
  }

  def deshacerEfectosExtras(engarzes:mutable.Set[Engarze], personaje: Personaje):Unit={
    if (engarzes.exists(_.isInstanceOf[RunaRO] && engarzes.exists(_.isInstanceOf[RunaMO]))) personaje.status.defensa -= 10
  }
}
