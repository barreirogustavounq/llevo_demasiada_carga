package LlevoDemasiadaCarga.Tomos

import LlevoDemasiadaCarga._

abstract class Tomo(nombreTomo: String, volumenTomo: Int, override var cantidadDeUsos: Int)
                                                                              extends Usable(nombreTomo, volumenTomo)
                                                                                with Consumible {

  override def usar(personaje: Personaje): Unit = { super.usar(personaje) }
  def puedeUsar(): Boolean = cantidadDeUsos > 0
}