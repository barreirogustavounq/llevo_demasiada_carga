package LlevoDemasiadaCarga.Engarzables.EfectosEngarzes

import LlevoDemasiadaCarga.Engarzables.Engarze
import LlevoDemasiadaCarga.Personaje

trait EfectoEngarzeAumentarVidaMaxima extends Engarze{
  var aumentoVidaMaxima:Int

  override def aplicar(personaje: Personaje): Unit = {
    personaje.vidaMaxima += this.aumentoVidaMaxima
    super.aplicar(personaje)
  }

  override def deshacer(personaje: Personaje): Unit = {
    personaje.vidaMaxima -= this.aumentoVidaMaxima
    super.deshacer(personaje)
  }
}
