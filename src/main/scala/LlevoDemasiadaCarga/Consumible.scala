package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Estados.EstadosDeUso.EstadoDeUso

import scala.collection.mutable

trait Consumible extends Item {

  var cantidadDeUsos: Int
  var estadosDeUso: mutable.Set[EstadoDeUso] = mutable.Set()

  abstract override def usar(personaje: Personaje): Unit = {
    this.cantidadDeUsos -= 1
    this.verificarDisponibilidad()
    super.usar(personaje)
  }

  // Verifica si puede seguir usando este Consumible dada su cantidadDeUsos.
  // Si no se puede seguir usando, se descarta del lugar donde esta almacenado.
  def verificarDisponibilidad(): Unit = {
    val estadoActual: Option[EstadoDeUso] = this.estadosDeUso.find((p: EstadoDeUso) => p.puedeUsarseConCantidad(cantidadDeUsos))
    estadoActual.get.hacerseCargoDe(this)
  }


}
