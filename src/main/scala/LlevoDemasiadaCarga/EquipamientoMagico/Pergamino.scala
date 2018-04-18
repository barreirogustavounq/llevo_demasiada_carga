package LlevoDemasiadaCarga.EquipamientoMagico

import LlevoDemasiadaCarga.Pilas.Apilable
import LlevoDemasiadaCarga.{Comerciable, Consumible, ItemBasico}

class Pergamino extends ItemBasico("Pergamino de identidad", 1) with Consumible with Comerciable with Apilable
{
  override var cantidadDeUsos: Int = 1
  override var cantidadMaximaApilables: Int = 3
  override val precioCompra: Int = 5
  override val precioVenta: Int = 3
}
