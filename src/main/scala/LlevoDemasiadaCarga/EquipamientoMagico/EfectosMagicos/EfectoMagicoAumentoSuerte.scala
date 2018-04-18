package LlevoDemasiadaCarga.EquipamientoMagico.EfectosMagicos

import LlevoDemasiadaCarga.EquipamientoMagico.{Magico, Pergamino}
import LlevoDemasiadaCarga.{ItemBasico, Personaje}

trait EfectoMagicoAumentoSuerte extends ItemBasico with Magico{

  var aumentoSuerte:Int

  override def identificar(pergamino: Pergamino, personaje: Personaje): Unit = {
    personaje.status.suerte += this.aumentoSuerte
    super.identificar(pergamino, personaje)
  }

  override def tirar(personaje: Personaje): Unit = {
    personaje.status.suerte -= this.aumentoSuerte
    super.tirar(personaje)
  }

}
