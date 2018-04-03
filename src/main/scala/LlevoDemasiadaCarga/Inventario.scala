package LlevoDemasiadaCarga

import scala.collection.mutable.ArrayBuffer

class Inventario(var capacidad: Int) {
  val items = new ArrayBuffer[Item]
  var cinturon: Cinturon = _
  var personaje: Personaje = _

  def recogerItem(item: Item): Unit = {
    if(puedoAgregar(item)) {
      this.items += item
      item.personaje = this.personaje
    }
  }

  def tirarItem(item: Item): Unit ={
    this.items -= item
  }

  def moverItemAlCinturon(pocion: Consumible): Unit = {
    if(this.cinturon.puedoAgregar()) {
      this.cinturon.agregarPocion(pocion)
      this.tirarItem(pocion)
    }
  }

  def puedoAgregar(item: Item): Boolean={
    var sum:Int = 0
    this.items.foreach(sum += _.volumen)
    (this.capacidad - sum) >= item.volumen
  }

  def tieneItem(item: Item): Boolean={
    this.items.contains(item)
  }
}
