package LlevoDemasiadaCarga.Engarzables.EfectosEngarzes

import LlevoDemasiadaCarga.Engarzables.Engarze
import LlevoDemasiadaCarga.Personaje

trait EfectoEngarzeAumentarMana extends Engarze{
  var aumentoMana:Int

  override def aplicar(personaje: Personaje): Unit = {
    personaje.status.mana += this.aumentoMana
    super.aplicar(personaje)
  }

  override def deshacer(personaje: Personaje): Unit = {
    personaje.status.mana -= this.aumentoMana
    super.deshacer(personaje)
  }
}
