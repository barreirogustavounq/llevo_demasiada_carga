package LlevoDemasiadaCarga.Equipables

import LlevoDemasiadaCarga.ItemBasico

class Slot () {
  var itemEquipado:Equipable = null

  def desequiparItem(): Unit = itemEquipado = null

  def equiparItem(item: Equipable) : Unit = itemEquipado = item

  def estaEquipado() : Boolean =  itemEquipado != null

}
