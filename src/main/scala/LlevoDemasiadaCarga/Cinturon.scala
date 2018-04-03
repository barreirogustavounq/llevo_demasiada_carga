package LlevoDemasiadaCarga

import scala.collection.mutable.ArrayBuffer


class Cinturon(var capacidad:Int, val inventario: Inventario) {
  val pociones = new ArrayBuffer[Item]()

  def agregarPocion(pocion: Item): Unit ={
    if(this.puedoAgregar() && pocion.isInstanceOf[Consumible]) this.pociones += pocion
  }

  def moverAlInventario(pocion: Item): Unit ={
    if(this.inventario.puedoAgregar(pocion)){
      this.inventario.recogerItem(pocion)
      this.pociones -= pocion
    }
  }

  def puedoAgregar(): Boolean={
    (this.capacidad - this.pociones.size) >= 1
  }

  def tieneItem(item: Item): Boolean ={
    this.pociones.contains(item)
  }

  def tirarItem(pocion: Item): Unit = {
    this.pociones -= pocion
  }
}
