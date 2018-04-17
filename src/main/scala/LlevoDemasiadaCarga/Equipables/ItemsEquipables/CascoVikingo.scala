package LlevoDemasiadaCarga.Equipables.ItemsEquipables

import LlevoDemasiadaCarga.Equipables.EfectosDeEquipables.EfectoAumentarDefensa
import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Equipables.Requerimientos.RequerimientoAgilidad
import LlevoDemasiadaCarga.Equipables.TiposDeEquipables.Casco
import LlevoDemasiadaCarga.ItemBasico

class CascoVikingo extends ItemBasico("Casco de vikingo", 2) with Casco with Equipable with EfectoAumentarDefensa
  with RequerimientoAgilidad{
  override var aumentoDefensa: Int = 5
  override var agilidadNecesaria: Int = 10
}
