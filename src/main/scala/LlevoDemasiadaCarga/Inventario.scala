package LlevoDemasiadaCarga

import scala.collection.mutable

class Inventario(var capacidad: Int){

  var items : mutable.Set[Item] = mutable.Set()

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
