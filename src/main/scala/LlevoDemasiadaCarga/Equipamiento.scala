package LlevoDemasiadaCarga

import scala.collection.mutable

class Equipamiento(nombre : String, val tipo : TipoDeItem, override val precioCompra: Int, override val precioVenta: Int)
  extends ItemBasico(nombre, tipo.volumen) with Equipable with Comerciable
{
  override val efectos: Efecto = tipo.efecto
  override val lugarDondeSeEquipa: String = tipo.lugarDeEquipamiento
  override val requerimientos: mutable.Set[Atributo] = tipo.requerimientos
}
