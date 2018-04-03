package LlevoDemasiadaCarga

trait Consumible extends Item{
  var cantidadDeUsos: Int

  def usar(personaje: Personaje): Unit = {
    this.cantidadDeUsos -= 1
    if(cantidadDeUsos == 0) personaje.eliminarDelInventario(this)
  }
}
