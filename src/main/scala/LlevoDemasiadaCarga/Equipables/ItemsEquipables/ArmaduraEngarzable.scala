package LlevoDemasiadaCarga.Equipables.ItemsEquipables

import LlevoDemasiadaCarga.Engarzables.Engarzable
import LlevoDemasiadaCarga.Equipables.EfectosDeEquipables.EfectoAumentarDefensa
import LlevoDemasiadaCarga.Equipables.TiposDeEquipables.Torso
import LlevoDemasiadaCarga.ItemBasico

class ArmaduraEngarzable extends ItemBasico("Armadura Engarzable", 10) with Torso with Engarzable with EfectoAumentarDefensa {
  override var cantidadEngarzes: Int = 3
  override var aumentoDefensa: Int = 20
}