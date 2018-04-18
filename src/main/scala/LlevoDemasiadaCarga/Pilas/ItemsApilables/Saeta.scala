package LlevoDemasiadaCarga.Pilas.ItemsApilables

import LlevoDemasiadaCarga.EfectosUsables.EfectoVidaActual
import LlevoDemasiadaCarga.Pilas.Apilable
import LlevoDemasiadaCarga.{Comerciable, Consumible, ItemBasico}

class Saeta extends ItemBasico("Flecha", 2) with Comerciable with Consumible with EfectoVidaActual with Apilable{
  override val precioCompra: Int = 1
  override val precioVenta: Int = 2
  override var valorDeEfecto: Int = 10
  override var cantidadDeUsos: Int = 1
  override var cantidadMaximaApilables = 5
}
