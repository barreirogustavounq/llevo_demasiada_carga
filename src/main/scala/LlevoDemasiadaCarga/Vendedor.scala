package LlevoDemasiadaCarga

class Vendedor(var inventario: Inventario) {

  // El Vendedor compra un item al Personaje.
  def comprar(item: Comerciable, personaje: Personaje): Unit = {
    personaje.adquirirOro(item.precioVenta)
    personaje.tirarItem(item)
    inventario.recogerItem(item)
  }

  // El Vendedor compra un item al Personaje.
  def vender(item: Comerciable, personaje: Personaje): Unit = {
    personaje.removerOro(item.precioCompra)
    inventario.tirarItem(item.nombre)
  }


}
