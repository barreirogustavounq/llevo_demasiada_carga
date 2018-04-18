package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.EquipamientoMagico.Magico
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentoAtaqueDefensa extends  Magico with EfectoAumentarAtaque with EfectoAumentarDefensa
{
  override var aumentoDeAtaque: Int = _
  override var aumentoDefensa: Int = _

  override def equipar(personaje: Personaje): Unit =
  {
    super.equipar(personaje)
    personaje.status.ataque += this.aumentoDeAtaque
    personaje.status.defensa += this.aumentoDefensa
  }
}