package LlevoDemasiadaCarga.Pilas

import LlevoDemasiadaCarga.Excepciones.{CantidadDeApilablesAlMaximoException, DiferenteTipoException}
import LlevoDemasiadaCarga.{Inventario, ItemBasico, Personaje}

trait Apilable extends ItemBasico
{
  var estado:EstadoDeApilamiento = new NoApilado
  var siguientePila:Apilable = _
  var anteriorPila:Apilable = _
  val volumenOriginal:Int = volumen
  var cantidadMaximaApilables:Int
  volumen = this.calcularVolumen()
  var miClase: Class[_ <: Apilable] = this.getClass

  def apilar(itemApilable: Apilable, inventario: Inventario): Unit={
    this.puedoApilar()
    this.esMismoTipo(itemApilable)
    this.estado.apilar(this, itemApilable, inventario)
  }

  def puedoApilar():Unit = if (!(this.cantidadDeApilables() < this.cantidadMaximaApilables)) throw CantidadDeApilablesAlMaximoException()

  def esMismoTipo(apilable: Apilable):Unit= if (!(apilable.getClass == this.getClass)) throw DiferenteTipoException()

  def cantidadDeApilables(): Int = {
    var cant = 1
    if(existeSiguiente()){
      cant = cant + this.siguientePila.cantidadDeApilables()
    }
    cant
  }

  def existeSiguiente(): Boolean = this.siguientePila != null

  def siguiente(): Apilable = this.siguientePila

  def calcularVolumen(): Int = estado.calcularVolumen(this, this.volumenOriginal)

  override def usar(personaje: Personaje): Unit = {
    estado.usar(this, personaje)
  }

  def usarAux(personaje: Personaje):Unit={
    super.usar(personaje)
  }

  def desapilar(): Apilable ={
    // El item desapilado se cae del inventario para que se pueda volver a recoger
    this.estado.desapilar(this)
  }

  override def calcularPrecioCompra():Int={
    estado.calcularPrecioCompra(this, this.precioCompra)
  }

  override def calcularPrecioVenta():Int={
    estado.calcularPrecioVenta(this, this.precioVenta)
  }
}
