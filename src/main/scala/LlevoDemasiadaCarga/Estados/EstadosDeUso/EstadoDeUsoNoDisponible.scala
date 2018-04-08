package LlevoDemasiadaCarga.Estados.EstadosDeUso
import LlevoDemasiadaCarga.Consumible

// Representa el estado en el que un Item Consumible puede usarse.
class EstadoDeUsoNoDisponible extends EstadoDeUso {

  // Realiza una accion sobre el consumible dependiendo de este Estado.
  override def hacerseCargoDe(consumible: Consumible): Unit = {
    consumible.esAlmacenadoEn.tirarItem(consumible.nombre)
    consumible.tirar()
  }

  // Verifica si el Item no puede usarse si tiene una cantidad dada.
  override def puedeUsarseConCantidad(cantidad: Int): Boolean = { cantidad < 1 }
}
