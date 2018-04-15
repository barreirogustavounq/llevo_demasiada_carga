package LlevoDemasiadaCarga

class ItemBasico(val nombre: String,var volumen: Int) extends Item{

  val precioVenta: Int = 0
  val precioCompra: Int = 0

  override def usar(personaje: Personaje): Unit={}

  def calcularPrecioCompra():Int={
    return precioCompra
  }

  def calcularPrecioVenta():Int={
    return precioVenta
  }

}
