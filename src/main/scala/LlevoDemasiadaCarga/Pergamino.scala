package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.EfectoMagico.Magico
import LlevoDemasiadaCarga.Equipables.EfectosDeEquipables.{EfectoAumentarAtaque, EfectoAumentarDefensa}
import LlevoDemasiadaCarga.Pilas.Apilable

class Pergamino(override val nombre : String, override val volumenOriginal: Int, override var cantidadMaximaApilables: Int)
         extends ItemBasico(nombre, volumenOriginal) with Consumible with Apilable
{

   def usar(personaje : Personaje, itemMagico: Magico[Any,Any]): Unit =
  {
    super.usar(personaje)
    itemMagico.identificado = true
  }
}
