package LlevoDemasiadaCarga.Engarzables.ItemsEngarzables

import LlevoDemasiadaCarga.Engarzables.EfectosEngarzes.EfectoEngarzeAumentarFueza
import LlevoDemasiadaCarga.Engarzables.Runa
import LlevoDemasiadaCarga.{Comerciable, ItemBasico}

class RunaMO extends ItemBasico("Runa MO", 1) with Runa with Comerciable with EfectoEngarzeAumentarFueza{
  override var aumentoFuerza: Int = 10
  override val precioCompra: Int = 10
  override val precioVenta: Int = 5
}
