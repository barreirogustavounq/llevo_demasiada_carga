package LlevoDemasiadaCarga.Equipables.Requerimientos

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Excepciones.NoCumpleRequerimientosException
import LlevoDemasiadaCarga.Personaje

trait RequerimientoAgilidad extends Equipable{
  var agilidadNecesaria:Int

  override def equipar(personaje: Personaje): Unit = {
    if (personaje.status.agilidad < agilidadNecesaria) throw NoCumpleRequerimientosException()
    super.equipar(personaje)
  }

}
