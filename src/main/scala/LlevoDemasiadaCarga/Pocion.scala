package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Efectos.EfectoVidaActual

class Pocion(nombre : String, volumen: Int, unValorDeEfecto: Int) extends Usable(nombre,volumen) with Consumible
                                                                    //with Apilable
                                                                    with EfectoVidaActual {

  override var cantidadDeUsos: Int = 1
  override def valorDeEfecto: Int = unValorDeEfecto

  override def usar(personaje: Personaje): Unit = super.usar(personaje)
}

// class item
//


// trait usable
// trait consumible
// trait efecto vida actual