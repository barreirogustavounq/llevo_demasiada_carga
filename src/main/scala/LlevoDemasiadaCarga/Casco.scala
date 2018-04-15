package LlevoDemasiadaCarga

class Casco(nombre : String, volumen : Int, val lugarDondeSeEquipa: String, override val efectos: Efecto)
  extends ItemBasico(nombre, volumen) with Equipable
{

}
