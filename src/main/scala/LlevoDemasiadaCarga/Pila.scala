package LlevoDemasiadaCarga

import scala.collection.mutable

abstract class Pila(val item : ItemBasico, var cantidad : Int) extends ItemBasico(item.nombre, (item.volumen * cantidad)/2 ) with Apilable
{
  //val tipo : Apilable = item[Apilable]
  var items : mutable.Set[Apilable] =   mutable.Set()
  def agregarItem(item : ItemBasico){ if(item.nombre == this.nombre & (maximo < cantidad) ){ cantidad += 1} }


}
