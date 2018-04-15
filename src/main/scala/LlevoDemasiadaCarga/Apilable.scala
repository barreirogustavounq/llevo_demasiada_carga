package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Pilas.{EstadoDeApilamiento, NoApilado}

trait Apilable extends ItemBasico
{
  /*val tipo : String
  var cantidad : Int
  val maximo : Int

  def aumentarPila() {cantidad += 1}
  def disminuirPila() {cantidad -= 1}
  def apilarItems(item1 : Apilable, item2 : Apilable){ }
  def usarPila()
  def precioCompraPila()
  def precioVentaPila()*/


  /*val pila:mutable.Set[T] = mutable.Set()

  def apilar(apilable: T):Unit={
    this.pila.add(apilable)
  }

  override val
*/
  var estado:EstadoDeApilamiento = new NoApilado
  var siguientePila:Apilable = null
  var anteriorPila:Apilable = null
  val volumenOriginal:Int = volumen
  volumen = this.calcularVolumen()

  def apilar(itemApilable: Apilable): Unit={
    this.estado.apilar(this, itemApilable)
  }

  def cantidadDeApilables():Int={
    var cant = 1
    if(existeSiguiente()){
      cant = cant + this.siguientePila.cantidadDeApilables()
    }
    return cant
  }

  def existeSiguiente():Boolean={
    return this.siguientePila != null
  }

  def siguiente():Apilable={
    return this.siguientePila
  }

  def calcularVolumen():Int={
    estado.calcularVolumen(this, this.volumenOriginal)
  }

  override def usar(personaje: Personaje): Unit = {
    estado.usar(this, personaje)
  }

  def usarAux(personaje: Personaje):Unit={
    super.usar(personaje)
  }

  def desapilar(): Apilable ={
    return this.estado.desapilar(this)
  }

  override def calcularPrecioCompra():Int={
    estado.calcularPrecioCompra(this, this.precioCompra)
  }

  override def calcularPrecioVenta():Int={
    estado.calcularPrecioVenta(this, this.precioVenta)
  }
}
