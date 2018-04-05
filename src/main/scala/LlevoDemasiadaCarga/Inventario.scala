package LlevoDemasiadaCarga

import scala.collection.mutable

class Inventario(val capacidadMaxima: Int){

  var volumenCargado: Int = capacidadMaxima
  var items : mutable.Set[Item] = mutable.Set()

  def recogerItem(item: Item): Unit = {
    if(puedoAgregar(item.volumen)) {
      this.items += item
      this.volumenCargado += item.volumen
    }
  }

  def tirarItem(nombreItem: String): Unit = {
    try {
      var itemATirar: Item = items.find((p:Item) => p.nombre.equals(nombreItem)).get
      this.items -= itemATirar
      this.volumenCargado -= itemATirar.volumen

    } catch  {
      case _: NoSuchElementException => print(s"No se encontro el Item $nombreItem a tirar.\n")
    }
  }

  def puedoAgregar(volumenDelItem: Int): Boolean={
    var sum:Int = 0
    this.items.foreach(sum += _.volumen)
    (this.capacidadMaxima - sum) >= volumenDelItem
  }

  def tieneItem(item: Item): Boolean={
    this.items.contains(item)
  }
}
