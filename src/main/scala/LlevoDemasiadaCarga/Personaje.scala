package LlevoDemasiadaCarga

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario) {

  def comprar(item: Item, vendedor: Vendedor) = {
    vendedor.vender(item, this)
  }

  var vidaActual = vidaMaxima
  var cinturon : Cinturon

  def eliminarDelInventario(item: Item): Unit ={
    if(this.inventario.tieneItem(item))this.inventario.tirarItem(item)
    if(this.cinturon.tieneItem(item)) {this.cinturon.tirarItem(item)}
  }
  def recogerItem(item : Item){ if(inventario.puedoAgregar(item)){ inventario.recogerItem(item)}else{println("no hay espacio suficiente")} }
  def tirarItem(item : Item) {inventario.tirarItem(item)}
  def usarItem(item : Item) { item.usar(this)}
  def moverItemAlCinturon(pocion: Consumible): Unit = {
    if(this.cinturon.puedoAgregar()) {
      this.cinturon.agregarPocion(pocion)
      this.tirarItem(pocion)
    }
  }
  def moverAlInventario(pocion: Item): Unit ={
    if(this.inventario.puedoAgregar(pocion)){
      this.inventario.recogerItem(pocion)
      this.cinturon.tirarItem(pocion)
    }
  }
}
