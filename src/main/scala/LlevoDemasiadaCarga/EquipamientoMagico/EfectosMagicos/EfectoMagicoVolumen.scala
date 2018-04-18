package LlevoDemasiadaCarga.EquipamientoMagico.EfectosMagicos

import LlevoDemasiadaCarga.EquipamientoMagico.{Magico, Pergamino}
import LlevoDemasiadaCarga.{ItemBasico, Personaje}

trait EfectoMagicoVolumen extends ItemBasico with Magico{
  var volumenNuevo:Int

  override def identificar(pergamino: Pergamino, personaje: Personaje): Unit = {
    this.volumen = this.volumenNuevo
    super.identificar(pergamino, personaje)
  }
}
