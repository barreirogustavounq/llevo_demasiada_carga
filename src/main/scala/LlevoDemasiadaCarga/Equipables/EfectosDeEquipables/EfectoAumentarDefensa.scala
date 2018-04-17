package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentarDefensa extends Equipable{
  var aumentoDefensa:Int

  override def equipar(personaje: Personaje): Unit = {
    personaje.status.defensa += this.aumentoDefensa
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje): Unit = {
    personaje.status.defensa -= this.aumentoDefensa
    super.desequipar(personaje)
  }

}
