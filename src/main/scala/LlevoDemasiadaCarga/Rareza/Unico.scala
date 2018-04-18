package LlevoDemasiadaCarga.Rareza

class Unico extends TipoRareza
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 2
}
