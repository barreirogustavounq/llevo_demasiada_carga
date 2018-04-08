package LlevoDemasiadaCarga.Efectos

import LlevoDemasiadaCarga.{Personaje, Usable}

trait EfectoVidaActual extends Usable{
  def valorDeEfecto: Int

  override def usar(personaje: Personaje): Unit = { personaje.vidaActual += this.valorDeEfecto }

}