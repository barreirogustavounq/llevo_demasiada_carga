package LlevoDemasiadaCarga.Equipables.ItemsEquipables

import LlevoDemasiadaCarga.Equipables.EfectosDeEquipables.EfectoAumentarAtaque
import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Equipables.Requerimientos.RequerimientoFuerza
import LlevoDemasiadaCarga.Equipables.TiposDeEquipables.ManoDerecha
import LlevoDemasiadaCarga.ItemBasico

class EspadaCorta extends ItemBasico("Espada Corta", 4) with ManoDerecha with Equipable with EfectoAumentarAtaque
  with RequerimientoFuerza{
  override var aumentoDeAtaque: Int = 10
  override var fuerzaNecesaria: Int = 20
}
