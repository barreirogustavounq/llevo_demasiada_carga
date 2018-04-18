package LlevoDemasiadaCarga.EquipamientoMagico.ItemsMagicos

import LlevoDemasiadaCarga.Equipables.ItemsEquipables.EspadaCorta
import LlevoDemasiadaCarga.EquipamientoMagico.EfectosMagicos.EfectoMagicoVolumen
import LlevoDemasiadaCarga.EquipamientoMagico.Magico

class EspadaCortaMagica extends EspadaCorta with Magico with EfectoMagicoVolumen{
  override var volumenNuevo: Int = 1
}
