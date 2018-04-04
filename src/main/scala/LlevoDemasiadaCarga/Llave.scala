package LlevoDemasiadaCarga

class Llave(nombreLlave : String, volumenLlave : Int) extends Item(nombreLlave, volumenLlave) with Usable {
  override def usar(){ println("se desbloqueo la puerta")}

  override def efecto(personaje: Personaje){}
}
