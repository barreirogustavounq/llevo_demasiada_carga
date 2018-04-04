package LlevoDemasiadaCarga

trait Consumible
{
  var cantidadDeUsos: Int

  def usar(personaje: Personaje)
}
