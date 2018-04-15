package LlevoDemasiadaCarga

abstract class Item {
  var volumen: Int //Esta de mas -- SACAR
  def usar(personaje: Personaje): Unit
}
