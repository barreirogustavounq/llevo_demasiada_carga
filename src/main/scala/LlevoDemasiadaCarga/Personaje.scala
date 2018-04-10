package LlevoDemasiadaCarga

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario, var oro: Int, val cinturon: Cinturon) {

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

  def usarItem(item : ItemBasico) { item.usar(this)}

  def moverItemDeInventarioAlCinturon(pocion: Pocion): Unit = {
    if(cinturon.puedoAgregar(pocion))
    {
      cinturon.agregarPocion(pocion)
      inventario.tirarItem(pocion)
    }
  }
  def moverAlInventario(pocion: Pocion): Unit ={
    if(this.inventario.puedoAgregar(pocion.volumen)){
      this.inventario.recogerItem(pocion)
      this.cinturon.tienePocion(pocion)
    }
  }
}
