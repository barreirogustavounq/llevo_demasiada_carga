package LlevoDemasiadaCarga

import scala.collection.mutable

class Cinturon(var nombreCinturon : String ,var capacidadCinturon:Int) extends ItemBasico(nombreCinturon ,capacidadCinturon) with Equipable {

  var pociones : mutable.Set[Pocion] = mutable.Set()

  def agregarPocion(pocion: Pocion) = if(puedoAgregar(pocion)){pociones.add(pocion)}
  def tirarPocion(pocion: Pocion): Unit ={
    this.pociones.remove(pocion)
  }


  def puedoAgregar(pocion: Pocion): Boolean={
    var sum:Int = 0
    this.pociones.foreach(sum += _.volumen)
    (this.capacidadCinturon - sum) >= pocion.volumen
  }

  def tienePocion(pocion: Pocion): Boolean={
    this.pociones.contains(pocion)
  }

  override def usar(personaje: Personaje): Unit = {}
}
