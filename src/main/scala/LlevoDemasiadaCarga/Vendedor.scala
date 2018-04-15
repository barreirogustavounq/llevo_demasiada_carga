package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Excepciones.{InsuficienteEspacioException, InsuficienteOroException}

class Vendedor(var inventario: Inventario) {

  def verificaSiTieneEspacioSuficiente(personaje: Personaje, volumenItem: Int): Unit = {
    if (!personaje.tieneEspacioPara(volumenItem)) { throw InsuficienteEspacioException() }
  }

  def verificaSiTieneOroSuficiente(personaje: Personaje, precioItem: Int): Unit = {
    if (!personaje.puedeComprarPorElMontoDe(precioItem)) {throw  InsuficienteOroException() }
  }

  def verificaSiPuedeVenderA(personaje: Personaje, item: Comerciable): Unit = {
    this.verificaSiTieneOroSuficiente(personaje, item.precioCompra)
    this.verificaSiTieneEspacioSuficiente(personaje, item.volumen)
  }

  // El Vendedor compra un item al Personaje.
  def comprar(item: Comerciable, personaje: Personaje): Unit = {
    personaje.adquirirOro(item.calcularPrecioVenta)
    personaje.tirarItem(item)
    inventario.recogerItem(item) // chequear que el item se esta guardando en vez de ser tirado y puede causar problemas
  }

  // El Vendedor vende un item al Personaje.
  def vender(item: Comerciable, personaje: Personaje): Unit = {
    try {
      this.verificaSiPuedeVenderA(personaje, item)
      personaje.removerOro(item.calcularPrecioCompra)
      personaje.recogerItem(item)
      inventario.tirarItem(item)
    }
    catch { case _ : InsuficienteOroException => print("No tienes suficiente oro.\n")
            case _ : InsuficienteEspacioException => print("No tienes suficiente espacio en el inventario.\n")
    }
}


}
