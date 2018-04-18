package LlevoDemasiadaCarga.Rareza

import LlevoDemasiadaCarga.Comerciable

trait Raro extends Comerciable
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 2

  override def calcularPrecioVenta(): Int = super.calcularPrecioVenta() * 2
}
