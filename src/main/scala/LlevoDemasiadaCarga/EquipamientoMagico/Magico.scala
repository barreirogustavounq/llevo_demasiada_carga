package LlevoDemasiadaCarga.EquipamientoMagico

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Excepciones.NoIdentificadoException
import LlevoDemasiadaCarga.Personaje

trait Magico extends Equipable
{
  var identificado = false

  override def equipar(personaje: Personaje): Unit = {
    if (this.identificado) {
      super.equipar(personaje)
    }else{
      throw NoIdentificadoException()
    }
  }

  def identificar(pergamino: Pergamino, personaje: Personaje): Unit ={
    pergamino.usar(personaje)
    this.identificado = true
  }

}
