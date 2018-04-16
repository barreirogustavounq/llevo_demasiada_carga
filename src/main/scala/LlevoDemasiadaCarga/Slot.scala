package LlevoDemasiadaCarga

class Slot (val lugar: String, var itemEquipado: ItemBasico with Equipable) {

  def desequiparItem(): Unit = itemEquipado = null

  def equiparItem(item: ItemBasico with Equipable) : Unit = itemEquipado = item

  def estaEquipado() : Boolean =  itemEquipado != null

}
