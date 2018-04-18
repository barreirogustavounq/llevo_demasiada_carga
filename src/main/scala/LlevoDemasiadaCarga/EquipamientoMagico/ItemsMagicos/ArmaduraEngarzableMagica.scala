package LlevoDemasiadaCarga.EquipamientoMagico.ItemsMagicos

import LlevoDemasiadaCarga.Equipables.ItemsEquipables.ArmaduraEngarzable
import LlevoDemasiadaCarga.EquipamientoMagico.EfectosMagicos.EfectoMagicoAumentoSuerte
import LlevoDemasiadaCarga.EquipamientoMagico.Magico

class ArmaduraEngarzableMagica extends ArmaduraEngarzable with Magico with EfectoMagicoAumentoSuerte{
  override var aumentoSuerte: Int = 20
}
