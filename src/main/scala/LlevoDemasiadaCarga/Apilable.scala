package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Excepciones.{CantidadDeApilablesAlMaximoException, DifenteTipoException}
import LlevoDemasiadaCarga.Pilas.{EstadoDeApilamiento, NoApilado}

trait Apilable extends ItemBasico
{
  var estado:EstadoDeApilamiento = new NoApilado
  var siguientePila:Apilable = null
  var anteriorPila:Apilable = null
  val volumenOriginal:Int = volumen
  var cantidadMaximaApilables:Int
  volumen = this.calcularVolumen()
  var miClase = this.getClass

  def apilar(itemApilable: Apilable, inventario: Inventario): Unit={
    this.puedoApilar()
    this.esMismoTipo(itemApilable)
    this.estado.apilar(this, itemApilable, inventario)
  }

  def puedoApilar():Unit = if (!(this.cantidadDeApilables() < this.cantidadMaximaApilables)) throw CantidadDeApilablesAlMaximoException()

  def esMismoTipo(apilable: Apilable):Unit= if (!(apilable.getClass == this.getClass)) throw DifenteTipoException()

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
    // El item desapilado se cae del inventario para que se pueda volver a recoger
    return this.estado.desapilar(this)
  }

  override def calcularPrecioCompra():Int={
    estado.calcularPrecioCompra(this, this.precioCompra)
  }

  override def calcularPrecioVenta():Int={
    estado.calcularPrecioVenta(this, this.precioVenta)
  }
}

