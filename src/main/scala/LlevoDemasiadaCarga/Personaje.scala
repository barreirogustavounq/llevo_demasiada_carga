package LlevoDemasiadaCarga

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario) {
  var vidaActual = vidaMaxima

  def eliminarDelInventario(item: Item): Unit ={
    if(this.inventario.tieneItem(item))this.inventario.tirarItem(item)
    if(this.inventario.cinturon.tieneItem(item)) {this.inventario.cinturon.tirarItem(item)}
  }
}
