package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.EfectoVidaActual

class Pocion(nombre:String, volumen:Int, valorEfecto:Int) extends ItemBasico(nombre, volumen) with Consumible with EfectoVidaActual{
  override var cantidadDeUsos: Int = 1
  override var valorDeEfecto = valorEfecto
}