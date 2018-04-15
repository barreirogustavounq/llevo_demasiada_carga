package LlevoDemasiadaCarga

import scala.collection.mutable

/*abstract class Pila(val item : ItemBasico, var cantidad : Int) extends ItemBasico(item.nombre, (item.volumen * cantidad)/2 ) with Apilable
{
  //val tipo : Apilable = item[Apilable]
  var items : mutable.Set[Apilable] =   mutable.Set()
  def agregarItem(item : ItemBasico){ if(item.nombre == this.nombre & (maximo < cantidad) ){ cantidad += 1} }


}*/

class Pila(nombrePila:String) extends ItemBasico(nombre = nombrePila, volumen = 0){
  type ItemApilable = ItemBasico with Apilable

  var items:mutable.Set[ItemApilable] = mutable.Set()
  var volumenUnico:Int = 0
  this.volumen = calcularVolumen()

  def calcularVolumen(): Int ={
    return (this.volumenUnico * items.size) / 2
  }

  def apilar(itemApilable: ItemApilable): Unit={
    this.items.add(itemApilable)
    this.volumenUnico = itemApilable.volumen
    itemApilable.volumen = 0
  }

  def cantidadDeApilables():Int= {
    return this.items.size
  }

  override def usar(personaje: Personaje): Unit = {
    var item = this.items.head
    item.usar(personaje)
    if(!personaje.tieneItem(item)){
      this.items = this.items.tail
    }
  }

  def desapilar(): ItemBasico = {
    var item = this.items.head
    this.items = this.items.tail
    item.volumen = this.volumenUnico

    item
  }



}
