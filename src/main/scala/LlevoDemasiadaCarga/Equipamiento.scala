package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.Efecto

import scala.collection.mutable

class Equipamiento(override val nombre: String,
                   val tipo : TipoDeItem,
                   override val precioCompra: Int,
                   override val precioVenta: Int)
  extends ItemBasico(nombre, tipo.volumen)
    with Equipable
    with Comerciable {

  override val efectos: mutable.Set[Efecto] = tipo.efecto
  override val lugarDondeSeEquipa: String = tipo.lugarDeEquipamiento
  override val requerimientos: mutable.Set[Atributo] = tipo.requerimientos
}
