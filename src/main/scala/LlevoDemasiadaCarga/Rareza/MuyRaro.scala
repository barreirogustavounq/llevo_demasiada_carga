package LlevoDemasiadaCarga.Rareza

import LlevoDemasiadaCarga.Comerciable

trait MuyRaro extends Comerciable
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 3
  override def calcularPrecioVenta(): Int = super.calcularPrecioVenta * 3

}
