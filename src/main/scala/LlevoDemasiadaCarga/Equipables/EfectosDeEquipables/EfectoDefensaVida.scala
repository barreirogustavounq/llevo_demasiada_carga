package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.EquipamientoMagico.Magico
import LlevoDemasiadaCarga.Personaje

trait EfectoDefensaVida extends  Magico with EfectoAumentarDefensa with EfectoAumentarVidaMaxima
{
  override var aumentoDefensa: Int = _
  override var aumentoVidaMaxima: Int = _

  override def equipar(personaje: Personaje): Unit =
  {
    super.equipar(personaje)
    personaje.status.defensa += this.aumentoDefensa
    personaje.status.vidaMaxima += this.aumentoVidaMaxima
  }
}