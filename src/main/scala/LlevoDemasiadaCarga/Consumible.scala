package LlevoDemasiadaCarga

trait Consumible extends Usable {
  var cantidadDeUsos: Int

  override def usar(personaje: Personaje): Unit = {
    super.usar(personaje)
    cantidadDeUsos -= 1 }
}
