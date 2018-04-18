package LlevoDemasiadaCarga.Rareza

class MuyRaro extends TipoRareza
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 2
}
