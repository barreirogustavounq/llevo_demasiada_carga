package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Pilas.Apilable

class Pergamino(val nombre : String, override val volumenOriginal: Int,  override var cantidadMaximaApilables: Int)
         extends ItemBasico(nombre, volumenOriginal) with Consumible with Apilable
{

   def usar(personaje : Personaje, itemMagico: ItemMagico): Unit =
  {
    super.usar(personaje)
    itemMagico.identificado = true
  }
}
