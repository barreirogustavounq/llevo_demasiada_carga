package LlevoDemasiadaCarga.Estados.EstadosDeUso
import LlevoDemasiadaCarga.Consumible

// Representa el estado en el que un Item Consumible puede usarse.
class EstadoDeUsoDisponible extends EstadoDeUso {

// Realiza una accion sobre el consumible dependiendo de este Estado.
override def hacerseCargoDe(consumible: Consumible): Unit = {}

// Verifica si el Item puede usarse si tiene una cantidad dada.
override def puedeUsarseConCantidad(cantidad: Int): Boolean = { cantidad > 0 }
}