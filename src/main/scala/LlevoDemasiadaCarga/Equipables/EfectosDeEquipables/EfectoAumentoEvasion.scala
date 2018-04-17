package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentoEvasion extends Equipable{
  var aumentoEvasion : Int

  override def equipar(personaje: Personaje): Unit = {
    personaje.status.evasion += this.aumentoEvasion
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje): Unit = {
    personaje.status.evasion -= this.aumentoEvasion
    super.desequipar(personaje)
  }
}