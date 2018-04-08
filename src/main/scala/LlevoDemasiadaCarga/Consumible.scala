package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Estados.EstadosDeUso.EstadoDeUso

import scala.collection.mutable

trait Consumible extends Usable {

  var cantidadDeUsos: Int
  var estadosDeUso: mutable.Set[EstadoDeUso] = mutable.Set()

  override def usar(personaje: Personaje): Unit = {
    super.usar(personaje)
    this.cantidadDeUsos -= 1
    this.verificarDisponibilidad()
  }

  // Verifica si puede seguir usando este Consumible dada su cantidadDeUsos.
  // Si no se puede seguir usando, se descarta del lugar donde esta almacenado.
  def verificarDisponibilidad(): Unit = {
    val estadoActual: Option[EstadoDeUso] = this.estadosDeUso.find((p: EstadoDeUso) => p.puedeUsarseConCantidad(cantidadDeUsos))
    estadoActual.get.hacerseCargoDe(this)
  }


}
