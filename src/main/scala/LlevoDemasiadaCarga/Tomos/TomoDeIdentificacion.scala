package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga.Personaje

class TomoDeIdentificacion(nombreTomo: String, volumenTomo: Int, cantidadDeUsos: Int)
  extends Tomo(nombreTomo, volumenTomo, cantidadDeUsos) {

  override def usar(personaje: Personaje): Unit = { super.usar(personaje) }
}
