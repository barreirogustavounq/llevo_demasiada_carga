package LlevoDemasiadaCarga

case class ItemBasico(val nombre: String,var volumen: Int) extends Item{

  val precioVenta: Int = 0
  val precioCompra: Int = 0


  def calcularPrecioCompra():Int={
    return precioCompra
  }

  def calcularPrecioVenta():Int={
    return precioVenta
  }

  override def usar(personaje: Personaje): Unit={}

}
