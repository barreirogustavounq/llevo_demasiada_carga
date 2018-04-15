package LlevoDemasiadaCarga

class Slot (val lugar : String, var  itemEqiupado : ItemBasico with  Equipable)
{
  def desequiparItem(): Unit =
  {
    var itemEquipado = null
  }

  def equiparItem(item: ItemBasico with Equipable) : Unit =
  {
    var itemEquipado = item
  }
  def estaEquipado() : Boolean =  itemEqiupado != null

}
