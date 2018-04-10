package LlevoDemasiadaCarga.Efectos

import LlevoDemasiadaCarga.{Item, Personaje}

trait EfectoVidaActual extends Item{
  var valorDeEfecto: Int

  abstract override def usar(personaje: Personaje): Unit={
    personaje.vidaActual += this.valorDeEfecto
    super.usar(personaje)
  }

}