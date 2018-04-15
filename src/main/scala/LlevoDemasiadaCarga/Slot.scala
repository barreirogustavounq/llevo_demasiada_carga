package LlevoDemasiadaCarga

class Slot (val lugar : String, var  itemEqiupado : ItemBasico with  Equipable)
{
  def equiparItem(item: ItemBasico with Equipable) : Unit =
  {
    var itemEquipado = item
  }
  def estaEquipado() : Boolean =  itemEqiupado != null

}
