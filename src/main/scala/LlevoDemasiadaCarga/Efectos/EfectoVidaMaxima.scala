package LlevoDemasiadaCarga.Efectos

import LlevoDemasiadaCarga.Personaje

trait EfectoVidaMaxima {
  def valorDeEfecto:Int

  def usar(personaje: Personaje): Unit ={
    personaje.vidaMaxima += this.valorDeEfecto
  }
}
