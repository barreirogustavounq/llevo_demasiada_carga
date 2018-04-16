package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.Efecto
import LlevoDemasiadaCarga.Excepciones.{AtributoNoEncontradoException, InsuficienteEspacioException}

import scala.collection.mutable

trait Equipable {
  val lugarDondeSeEquipa : String
  val requerimientos : mutable.Set[Atributo] = mutable.Set()
  val efectos: mutable.Set[Efecto] = mutable.Set()

  // Aplica el Efecto correspondiente al Atributo dado.
  // Levanta una excepsion en caso de no encontrar el Efecto.
  def aplicarEfecto(efecto: Efecto, atributos: mutable.Set[Atributo]): Unit = {
    val atributo: Atributo = atributos.find((a: Atributo) => a.nombre.equals(efecto.nombreAtributo)).
      getOrElse(throw AtributoNoEncontradoException())

    efecto.aplicar(atributo)
  }

  // Aplica todos los Efectos del Equipable al Personaje.
  def aplicarEfectos(personaje: Personaje): Unit = {
    for (efecto <- efectos) {
      aplicarEfecto(efecto, personaje.estatus)
    }
  }

}
