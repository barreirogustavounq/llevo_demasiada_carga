package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Excepciones.ItemNoAdmitidoEnCinturonException
import scala.collection.mutable

class Cinturon(var nombreCinturon: String , var capacidadCinturon:Int)
  extends ItemBasico(nombreCinturon , capacidadCinturon) with Equipable {

  override val efectos: Efecto = null
  override val lugarDondeSeEquipa: String = "Cintura"
  var pociones : mutable.Set[ItemBasico] = mutable.Set()

  def agregarPocion(item: ItemBasico): Unit = if (puedoAgregar(item)) pociones.add(item)

  def tirarPocion(pocion: Pocion): Unit = this.pociones.remove(pocion)

  def puedoAgregar(item: ItemBasico): Boolean={
    this.verificarSiEsUnaPocion(item)
    var sum:Int = 0
    this.pociones.foreach(sum += _.volumen)
    (this.capacidadCinturon - sum) >= item.volumen
  }

  def tienePocion(pocion: Pocion): Boolean = this.pociones.contains(pocion)

  def verificarSiEsUnaPocion(item: ItemBasico): Unit = {
    if (!item.isInstanceOf[Pocion]) throw ItemNoAdmitidoEnCinturonException()
  }

  override def usar(personaje: Personaje): Unit = {}
}

