package LlevoDemasiadaCarga

class Pocion(nombre : String, volumen: Int) extends Item(nombre,volumen) with Consumible with Apilable {
  override var cantidadDeUsos: Int = _

}
