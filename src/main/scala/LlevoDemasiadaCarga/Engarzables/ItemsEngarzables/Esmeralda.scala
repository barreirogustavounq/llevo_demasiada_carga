package LlevoDemasiadaCarga.Engarzables.ItemsEngarzables

import LlevoDemasiadaCarga.Engarzables.EfectosEngarzes.EfectoEngarzeAumentarMana
import LlevoDemasiadaCarga.Engarzables.Gema
import LlevoDemasiadaCarga.{Comerciable, ItemBasico}

class Esmeralda extends ItemBasico("Esmeralda de mana", 1) with Gema with Comerciable with EfectoEngarzeAumentarMana{
  override var aumentoMana: Int = 100
  override val precioCompra: Int = 10
  override val precioVenta: Int = 5
}
