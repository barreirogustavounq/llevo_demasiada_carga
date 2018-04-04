package LlevoDemasiadaCarga

import com.sun.xml.internal.bind.v2.model.core.MaybeElement

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario) {
  var vidaActual = vidaMaxima
  var cinturon : Cinturon = MaybeElement[Cinturon]

  def recogerItem(item : Item){ if(inventario.puedoAgregar(item)){ inventario.recogerItem(item)}else{println("no hay espacio suficiente")} }
  def tirarItem(item : Item) {inventario.tirarItem(item)}
  def usarItem(item : Item) { item.usar(this)}
  def moverItemDeInventarioAlCinturon(pocion: Pocion): Unit = {
    if(cinturon.puedoAgregar(pocion))
    {
      cinturon.agregarPocion(pocion)
      inventario.tirarItem(pocion)
    }
  }
  def moverAlInventario(pocion: Pocion): Unit ={
    if(this.inventario.puedoAgregar(pocion)){
      this.inventario.recogerItem(pocion)
      this.cinturon.tienePocion(pocion)
    }
  }
}
