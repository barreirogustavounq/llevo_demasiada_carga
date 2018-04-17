package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentarAtaque extends Equipable{
  var aumentoDeAtaque:Int

  override def equipar(personaje: Personaje): Unit = {
    personaje.status.ataque += this.aumentoDeAtaque
    super.equipar(personaje)
  }

  override def desequipar(personaje: Personaje): Unit = {
    personaje.status.ataque -= this.aumentoDeAtaque
    super.desequipar(personaje)
  }
}
