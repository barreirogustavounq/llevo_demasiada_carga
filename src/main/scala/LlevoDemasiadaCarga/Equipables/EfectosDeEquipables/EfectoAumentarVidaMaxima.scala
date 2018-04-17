package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentarVidaMaxima extends Equipable{
  var aumentoVidaMaxima : Int

  override def equipar(personaje: Personaje): Unit = {
    personaje.status.vidaMaxima += this.aumentoVidaMaxima
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje): Unit = {
    personaje.status.vidaMaxima -= this.aumentoVidaMaxima
    super.desequipar(personaje)
  }

}
