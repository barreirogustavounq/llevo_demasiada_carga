package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga.Personaje

class TomoDePortal(nombreTomo : String, volumenTomo : Int) extends Tomo(nombreTomo, volumenTomo) {
  override var usos: Int = _

  override def usar(personaje: Personaje): Unit = {if(puedeUsar()){println("portal abierto")} }

}
