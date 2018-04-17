package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentarSuerte extends Equipable{
  var aumentoSuerte : Int

  override def equipar(personaje: Personaje): Unit = {
    personaje.status.suerte += this.aumentoSuerte
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje): Unit = {
    personaje.status.suerte -= this.aumentoSuerte
    super.desequipar(personaje)
  }

}