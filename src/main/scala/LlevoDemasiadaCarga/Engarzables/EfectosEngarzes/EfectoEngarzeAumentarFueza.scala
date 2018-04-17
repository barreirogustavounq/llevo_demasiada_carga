package LlevoDemasiadaCarga.Engarzables.EfectosEngarzes

import LlevoDemasiadaCarga.Engarzables.Engarze
import LlevoDemasiadaCarga.Personaje

trait EfectoEngarzeAumentarFueza extends Engarze{
  var aumentoFuerza:Int

  override def aplicar(personaje: Personaje): Unit = {
    personaje.status.fuerza += this.aumentoFuerza
    super.aplicar(personaje)
  }

  override def deshacer(personaje: Personaje): Unit = {
    personaje.status.fuerza -= this.aumentoFuerza
    super.deshacer(personaje)
  }

}
