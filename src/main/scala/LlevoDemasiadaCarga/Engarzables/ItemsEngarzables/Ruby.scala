package LlevoDemasiadaCarga.Engarzables.ItemsEngarzables

import LlevoDemasiadaCarga.Engarzables.EfectosEngarzes.EfectoEngarzeAumentarVidaMaxima
import LlevoDemasiadaCarga.Engarzables.Gema
import LlevoDemasiadaCarga.{Comerciable, ItemBasico}

class Ruby extends ItemBasico("Ruby de vida", 1) with Comerciable with Gema with EfectoEngarzeAumentarVidaMaxima{
  override var aumentoVidaMaxima: Int = 100
  override val precioCompra: Int = 10
  override val precioVenta: Int = 5
}
