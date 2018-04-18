package LlevoDemasiadaCarga.Rareza

import LlevoDemasiadaCarga.Comerciable

trait Unico extends Comerciable
{
  override def calcularPrecioCompra(): Int = super.calcularPrecioCompra * 2
}
