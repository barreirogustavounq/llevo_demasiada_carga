package LlevoDemasiadaCarga.Equipables.EfectosDeEquipables

import LlevoDemasiadaCarga.EquipamientoMagico.Magico
import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Personaje

trait EfectoAumentoAtaqueVida extends Magico with EfectoAumentarAtaque with EfectoAumentarVidaMaxima
{
  override var aumentoDeAtaque: Int = _
  override var aumentoVidaMaxima: Int = _

  override def equipar(personaje: Personaje): Unit =
  {
    super.equipar(personaje)
    personaje.status.ataque += this.aumentoDeAtaque
    personaje.status.vidaMaxima += this.aumentoVidaMaxima
  }
}