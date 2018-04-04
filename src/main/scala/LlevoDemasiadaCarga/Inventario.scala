package LlevoDemasiadaCarga

import scala.collection.mutable.ArrayBuffer

class Inventario(var capacidad: Int){

  val items = new ArrayBuffer[Item]

  def recogerItem(item: Item): Unit = {
    if(puedoAgregar(item)) {
      this.items += item
    }
  }

  def tirarItem(item: Item): Unit ={
    this.items -= item
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
