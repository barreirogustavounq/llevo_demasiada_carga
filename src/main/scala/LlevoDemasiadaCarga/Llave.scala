package LlevoDemasiadaCarga

class Llave(nombreLlave : String, volumenLlave : Int) extends Usable(nombreLlave, volumenLlave) {
  override def usar(personaje: Personaje){ println("se desbloqueo la puerta")}

}
