package LlevoDemasiadaCarga.Pilas

import LlevoDemasiadaCarga.{Apilable, ItemBasico, Personaje}

abstract class EstadoDeApilamiento {

  def usar(pila:Apilable, personaje: Personaje):Unit
  def apilar(pila:Apilable, itemNuevo:Apilable):Unit
  def calcularVolumen(pila: Apilable, volumenOriginal:Int):Int
  def desapilar(pila:Apilable):Apilable
  def calcularPrecioCompra(apilable: Apilable, precioCompra:Int):Int
  def calcularPrecioVenta(apilable: Apilable, precioVenta:Int):Int
}
