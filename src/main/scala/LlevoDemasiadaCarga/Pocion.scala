package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.EfectoVidaActual

class Pocion(override val nombre: String, override val volumen: Int, unValorDeEfecto: Int)
  extends Usable(nombre, volumen)
  with Consumible
  with EfectoVidaActual {

  override var cantidadDeUsos: Int = 1
  override def valorDeEfecto: Int = unValorDeEfecto

  override def usar(personaje: Personaje): Unit = super.usar(personaje)
}