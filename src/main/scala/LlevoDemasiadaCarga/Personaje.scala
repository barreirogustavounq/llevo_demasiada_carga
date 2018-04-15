package LlevoDemasiadaCarga

import scala.collection.mutable

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario, var oro: Int, val cinturon: Cinturon) {
  var estatus : mutable.Set[Atributo] = mutable.Set()
  var slotsEquipables : mutable.Set[Slot] = mutable.Set()

  var vidaActual: Int = vidaMaxima

  def puedeComprarPorElMontoDe(unMonto: Int): Boolean = { oro >= unMonto }

  def tieneEspacioPara(volumenItem: Int): Boolean = { inventario.puedoAgregar(volumenItem) }

  // Dado un monto de oro, se remueve esta cantidad a la que tiene el personaje.
  def removerOro(unMonto: Int): Unit = { oro -= unMonto}

  def adquirirOro(unMonto: Int): Unit = { oro += unMonto }

  def comprar(item: Comerciable, vendedor: Vendedor): Unit = { vendedor.vender(item, this) }

  def vender(item: Comerciable, vendedor: Vendedor): Unit = { vendedor.comprar(item, this) }

  def recogerItem(item : ItemBasico){ inventario.recogerItem(item) }

  def tirarItem(item : ItemBasico) {inventario.tirarItem(item)}

  def usarItem(item : Item) { item.usar(this)}

  def moverItemDeInventarioAlCinturon(pocion: ItemBasico): Unit = {
    if(cinturon.puedoAgregar(pocion))
    {
      cinturon.agregarPocion(pocion)
      inventario.tirarItem(pocion)
    }
  }

  def moverAlInventario(pocion: Pocion): Unit ={
    if(this.inventario.puedoAgregar(pocion.volumen)){
      this.inventario.recogerItem(pocion)
      this.cinturon.tirarPocion(pocion)
    }
  }

  def tieneItem(item:ItemBasico): Boolean = this.inventario.tieneItem(item)

  def puedeEquiparItem(item: ItemBasico with Equipable): Boolean =
  {
    var contador : Int = 0
    for( r <- item.requerimientos)
     {
       if(estatus.filter(_.eq(r.nombre)).head.cantidad >= r.cantidad){ contador + 1}
     }
    contador == item.requerimientos.size
  }
  def equiparITemEnSlot(item : ItemBasico with Equipable, slot : Slot)
  {
    slot.equiparItem(item)
    inventario.tirarItem(item)
  }

  def equiparItem(item : ItemBasico with Equipable): Unit =
  {
    if(puedeEquiparItem(item))
    {
      for(s <- slotsEquipables)
      {
        if(s.lugar == item.lugarDondeSeEquipa)
        {
          if(s.estaEquipado())
          {
            inventario.recogerItem(s.itemEqiupado)
            equiparITemEnSlot(item, s)
          }
          else
          {
            equiparITemEnSlot(item, s)
          }
        }
      }
    }
  }
}
