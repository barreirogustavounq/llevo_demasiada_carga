package LlevoDemasiadaCarga

import scala.collection.mutable

abstract class Pila(val item : Item, var cantidad : Int) extends Item(item.nombre, (item.volumen * cantidad)/2 ) with Apilable
{
  val tipo : Apilable = item[Apilable]
  var items : mutable.Set[Apilable] =   mutable.Set()
  def agregarItem(item : Item){ if(item.nombre == this.nombre & (maximo < cantidad) ){ cantidad += 1} }


}
