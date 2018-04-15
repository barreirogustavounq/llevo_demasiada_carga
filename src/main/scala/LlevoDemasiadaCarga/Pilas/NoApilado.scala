package LlevoDemasiadaCarga.Pilas

import LlevoDemasiadaCarga.{Apilable, Inventario, Personaje}

class NoApilado extends EstadoDeApilamiento {

  override def usar(pila:Apilable, personaje: Personaje): Unit ={
    pila.usarAux(personaje)
  }

  override def apilar(pila: Apilable, itemNuevo: Apilable, inventario: Inventario): Unit = {
    pila.siguientePila = itemNuevo
    pila.estado = new Apilado
    itemNuevo.anteriorPila = pila
    itemNuevo.estado = new Apilado
    inventario.tirarItem(itemNuevo)
  }

  override def calcularVolumen(pila: Apilable, volumenOriginal:Int): Int = {
    return volumenOriginal
  }

  override def desapilar(pila: Apilable): Apilable = {
    return pila
  }

  override def calcularPrecioCompra(apilable: Apilable, precioCompra: Int): Int = {
    return precioCompra
  }

  override def calcularPrecioVenta(apilable: Apilable, precioVenta: Int): Int = {
    return precioVenta
  }
}
