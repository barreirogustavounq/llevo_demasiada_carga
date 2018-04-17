package LlevoDemasiadaCarga.Engarzables.ItemsEngarzables

import LlevoDemasiadaCarga.Engarzables.EfectosEngarzes.EfectoEngarzeAumentarVidaMaxima
import LlevoDemasiadaCarga.Engarzables.Runa
import LlevoDemasiadaCarga.{Comerciable, ItemBasico}

class RunaRO extends ItemBasico("Runa RO", 1) with Runa with Comerciable with EfectoEngarzeAumentarVidaMaxima{
  override var aumentoVidaMaxima: Int = 100
  override val precioCompra: Int = 10
  override val precioVenta: Int = 5
}
