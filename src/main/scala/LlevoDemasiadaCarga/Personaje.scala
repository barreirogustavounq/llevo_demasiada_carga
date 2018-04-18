package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.EquipamientoMagico.{Magico, Pergamino}
import LlevoDemasiadaCarga.Equipables.ItemsEquipables.Cinturon
import LlevoDemasiadaCarga.Equipables.{Equipable, Slot}

import scala.collection.mutable

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario, var oro: Int, val cinturon: Cinturon) {
  var status : Status = new Status()
  var slotsEquipables : mutable.Set[Slot] = mutable.Set()
  var equipo:Equipo = new Equipo(this)
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

  def tieneItemEnInventario(item:ItemBasico): Boolean = this.inventario.tieneItem(item)

  def equiparItem(item : ItemBasico with Equipable): Unit = {
    this.equipo.equiparItem(item)
  }

  def desequiparItem(item: ItemBasico with Equipable): Unit = {
    this.equipo.desequiparItem(item)
  }

  def tirarItemEquipado(item: ItemBasico with Equipable): Unit ={
    this.equipo.tirarItemEquipado(item)
  }

  def identificarItem(item : ItemBasico with Magico, pergamino : Pergamino): Unit =
  {
    if(tieneItemEnInventario(pergamino))
    {
      pergamino.usar(this, item)
    }
  }

}
