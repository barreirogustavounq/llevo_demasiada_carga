package LlevoDemasiadaCarga.Estados.EstadosDeUso

import LlevoDemasiadaCarga.Consumible

abstract class EstadoDeUso {
  def hacerseCargoDe(consumible: Consumible): Unit
  def puedeUsarseConCantidad(cantidad: Int): Boolean
}
