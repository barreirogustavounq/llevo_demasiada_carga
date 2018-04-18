package LlevoDemasiadaCarga.Rareza

class Raro() extends TipoRareza("Raro")
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 2
}
