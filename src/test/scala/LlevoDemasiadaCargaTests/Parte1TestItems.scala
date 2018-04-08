package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Tomos.{Tomo, TomoDePortal}
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte1TestItems extends FunSuite with BeforeAndAfter {

  // SETUP
  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 0, cinturon)
  val pocionDeVida: Pocion = new Pocion("Pocion de vida menor", 1, 5)
  val tomo: Tomo = new TomoDePortal("Tomo de Portal a Tristan", 2, 2)

  // Limpia el inventario entre cada Test.
  after{
    inventario.items.clear()
    inventario.volumenCargado = 0
  }

  // TESTING

  /* Un Personaje usa un Item y ocurre un Efecto en el Personaje. */
  test("ElPersonajeUsaUnaPocionDeSaludYSeCuraCincoPuntos") {
    this.personaje.vidaActual = 90
    this.personaje.usarItem(pocionDeVida)
    assert(this.personaje.vidaActual.equals(95))
  }


  // Un Personaje usa un Item Consumible y se disminuye la cantidad de usos.
  test("ElPersonajeUsaUnTomoElCualDisminuyeSuCantidadDeUsos") {
    assert(this.tomo.cantidadDeUsos.equals(2))
    this.personaje.usarItem(tomo)
    assert(this.tomo.cantidadDeUsos.equals(1))
  }

  // Un personaje usa un ultimo Item Consumible y se remueve del Inventario.

  // Un Personaje usa una Pocion y se remueve del Inventario.

  // Se mueve una Pocion del Inventario al Cinturon.

  // Se mueve una Pocion del Cinturon al Inventario.

  // Se intenta mover un Item que no es una Pocion al Cinturon, e imprime un mensaje de error en pantalla.


}
