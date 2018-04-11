package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.{Comerciable, ItemBasico}
import org.scalatest.TestSuite

class Parte3TestApilables extends TestSuite{

  class Flecha extends ItemBasico("Flecha", 2) with Comerciable {
    override val precioCompra: Int = 1
    override val precioVenta: Int = 2}

  val flecha1: Flecha = new Flecha
  val flecha2: Flecha = new Flecha
  val flecha3: Flecha = new Flecha



}
