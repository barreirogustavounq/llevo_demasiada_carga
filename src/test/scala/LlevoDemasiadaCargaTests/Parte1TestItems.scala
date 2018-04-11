package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte1TestItems extends FunSuite with BeforeAndAfter {

  // SETUP
  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 0, cinturon)
  val pocionDeVida: Pocion = new Pocion("Pocion de vida menor", 1, 5)
  val tomo:ItemBasico = new ItemBasico("Tomo de Portal a Tristan", 1) with Consumible{override var cantidadDeUsos=2}

  before{
    this.personaje.recogerItem(pocionDeVida)
    this.pocionDeVida.cantidadDeUsos = 1
  }

  // Limpia el inventario entre cada Test.
  after{
    inventario.tirarTodo()
  }

  // TESTING

  /* Un Personaje usa un Item y ocurre un Efecto en el Personaje. */
  test("ElPersonajeUsaUnaPocionDeSaludYSeCuraCincoPuntos") {
    this.personaje.recogerItem(this.pocionDeVida)
    this.personaje.vidaActual = 90
    this.personaje.usarItem(pocionDeVida)

    assert(this.personaje.vidaActual.equals(95))
  }


  // Un Personaje usa un Item Consumible y se disminuye la cantidad de usos.
  test("ElPersonajeUsaUnTomoElCualDisminuyeSuCantidadDeUsos") {
    this.personaje.usarItem(tomo)
  }

  // Un personaje usa un ultimo Item Consumible y se remueve del Inventario.
  test("ElPersonajeUsaUnUltimoTomoYSeRemueveDelInventario") {
    this.personaje.usarItem(tomo)
    this.personaje.usarItem(tomo)

    assert(!this.personaje.inventario.tieneItem(tomo))
  }

  // Un Personaje usa una Pocion y se remueve del Inventario.
  test("ElPersonajeUsaUnaPocionDelInventarioYEstaEsRemovida") {
    this.personaje.usarItem(pocionDeVida)

    assert(this.pocionDeVida.cantidadDeUsos.equals(0))
    assert(!this.personaje.inventario.tieneItem(pocionDeVida))
  }


  // Se mueve una Pocion del Inventario al Cinturon.

  // Se mueve una Pocion del Cinturon al Inventario.

  // Se intenta mover un Item que no es una Pocion al Cinturon, y no puede.

}
