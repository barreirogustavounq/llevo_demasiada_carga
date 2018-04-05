package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Excepciones.InsuficienteOroException

class Personaje(val nombre:String, var vidaMaxima: Int, var armadura:Int, var ataque:Int, val inventario: Inventario, var oro: Int, val cinturon: Cinturon) {

  var vidaActual: Int = vidaMaxima

  // Dado un monto de oro, se remueve esta cantidad a la que tiene el personaje.
  // En caso de que no tenga oro suficiente, se levanta una excepcion.
  def removerOro(unMonto: Int): Unit = {
    try {
      if (oro >= unMonto) { oro -= unMonto }
      else { throw InsuficienteOroException() }

    } catch { case _ : InsuficienteOroException => print("No tienes suficiente oro.\n")}
    }


  def adquirirOro(unMonto: Int): Unit = { oro += unMonto }

  def comprar(item: Comerciable, vendedor: Vendedor): Unit = { vendedor.vender(item, this) }

  def vender(item: Comerciable, vendedor: Vendedor): Unit = { vendedor.comprar(item, this) }

  def recogerItem(item : Item){
    if(inventario.puedoAgregar(item.volumen)){ inventario.recogerItem(item)}
    else{println("no hay espacio suficiente")} }

  def tirarItem(item : Item) {inventario.tirarItem(item.nombre)}

  def usarItem(item : Item) { item.usar(this)}

  def moverItemDeInventarioAlCinturon(pocion: Pocion): Unit = {
    if(cinturon.puedoAgregar(pocion))
    {
      cinturon.agregarPocion(pocion)
      inventario.tirarItem(pocion.nombre)
    }
  }
  def moverAlInventario(pocion: Pocion): Unit ={
    if(this.inventario.puedoAgregar(pocion.volumen)){
      this.inventario.recogerItem(pocion)
      this.cinturon.tienePocion(pocion)
    }
  }
}
