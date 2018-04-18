package LlevoDemasiadaCarga.EquipamientoMagico.EfectosMagicos

import LlevoDemasiadaCarga.EquipamientoMagico.{Magico, Pergamino}
import LlevoDemasiadaCarga.{ItemBasico, Personaje}

trait EfectoMagicoVolumen extends ItemBasico with Magico{
  override def identificar(pergamino: Pergamino, personaje: Personaje): Unit = {
    this.volumen = 1
    super.identificar(pergamino, personaje)
  }
}
