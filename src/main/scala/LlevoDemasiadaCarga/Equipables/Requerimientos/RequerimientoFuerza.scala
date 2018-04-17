package LlevoDemasiadaCarga.Equipables.Requerimientos

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Excepciones.NoCumpleRequerimientosException
import LlevoDemasiadaCarga.Personaje

trait RequerimientoFuerza extends Equipable{
  var fuerzaNecesaria:Int

  override def equipar(personaje: Personaje): Unit = {
    if (personaje.status.fuerza < this.fuerzaNecesaria) throw NoCumpleRequerimientosException()
    super.equipar(personaje)
  }

}
