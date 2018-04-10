package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.EfectoVidaActual

class Pocion(nombre:String, volumen:Int, cantidadUsos:Int, valorEfecto:Int) extends ItemBasico(nombre, volumen) with Consumible with EfectoVidaActual{
  override var cantidadDeUsos: Int = cantidadUsos
  override var valorDeEfecto = valorEfecto
}