package LlevoDemasiadaCarga.Pilas

import LlevoDemasiadaCarga.{Apilable, Inventario, Personaje}

class Apilado extends EstadoDeApilamiento {

  override def usar(pila:Apilable, personaje: Personaje): Unit ={
    if(pila.existeSiguiente()){
      pila.siguientePila.usar(personaje)
    }
    else {
      pila.usarAux(personaje)
      if(!personaje.tieneItem(pila)){
        pila.anteriorPila.siguientePila = null
        pila.anteriorPila = null
        pila.estado = new NoApilado
      }
    }

  }

  override def apilar(pila: Apilable, itemNuevo: Apilable, inventario: Inventario): Unit = {
    if(pila.existeSiguiente()){
      pila.siguientePila.apilar(itemNuevo, inventario)
    }
    else {
      pila.siguientePila = itemNuevo
      itemNuevo.estado = new Apilado
      itemNuevo.anteriorPila = pila
      inventario.tirarItem(itemNuevo)
    }

  }

  override def calcularVolumen(pila: Apilable, volumenOriginal: Int): Int = {
    var cont:Int = volumenOriginal / 2
    if(pila.existeSiguiente()){
      cont = cont + pila.siguiente().calcularVolumen()
    }
    return cont
  }

  override def desapilar(pila: Apilable): Apilable = {
    if(pila.existeSiguiente()){
      pila.siguientePila.desapilar()
    }
    else {
      pila.anteriorPila.siguientePila = null
      pila.anteriorPila = null
      pila.estado = new NoApilado
      return pila
    }
  }

  override def calcularPrecioCompra(apilable: Apilable, precioCompra: Int): Int = {
    var cont:Int = precioCompra
    if(apilable.existeSiguiente()){
      cont = cont + apilable.siguiente().calcularPrecioCompra()
    }
    return cont
  }

  override def calcularPrecioVenta(apilable: Apilable, precioVenta: Int): Int = {
    var cont:Int = precioVenta
    if(apilable.existeSiguiente()){
      cont = cont + apilable.siguiente().calcularPrecioVenta()
    }
    return cont
  }
}
