package LlevoDemasiadaCarga.Equipables.ItemsEquipables

import LlevoDemasiadaCarga.Equipables.EfectosDeEquipables.EfectoAumentarDefensa
import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Equipables.Requerimientos.{RequerimientoAgilidad, RequerimientoFuerza}
import LlevoDemasiadaCarga.Equipables.TiposDeEquipables.Torso
import LlevoDemasiadaCarga.ItemBasico

class ArmaduraCuero extends ItemBasico("Armadura de cuero", 5) with Torso with Equipable with EfectoAumentarDefensa with RequerimientoAgilidad
  with RequerimientoFuerza {
  override var aumentoDefensa: Int = 20
  override var agilidadNecesaria: Int = 15
  override var fuerzaNecesaria: Int = 15
}
