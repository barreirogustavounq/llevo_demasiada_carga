package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Efectos.Efecto
import LlevoDemasiadaCarga.Excepciones.{AtributoNoEncontradoException, NoCumpleRequerimientosException}
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable

class Parte4TestEquipamiento extends FunSuite with BeforeAndAfter {

  // Setup Personaje
  val inventario:Inventario = new Inventario(24)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)
  val slotCasco: Slot = new Slot("Casco", null)
  val slotTorso: Slot = new Slot("Torso", null)
  val slotGuantes: Slot = new Slot("Guantes", null)
  val atributoArmadura: Atributo = new Atributo("Armadura", 0)
  this.personaje.slotsEquipables.add(slotCasco)
  this.personaje.slotsEquipables.add(slotTorso)
  this.personaje.slotsEquipables.add(slotGuantes)
  this.personaje.estatus.add(atributoArmadura)

  // Setup Efectos del Equipable
  val efectoArmadura: Efecto = new Efecto("Armadura", 12)
  val efectoFuerza: Efecto = new Efecto("Fuerza", 10)
  val efectosTorso: mutable.Set[Efecto] = mutable.Set()
  val efectosCasco: mutable.Set[Efecto] = mutable.Set()
  val efectosGuantes: mutable.Set[Efecto] = mutable.Set()
  this.efectosCasco.add(efectoArmadura)
  this.efectosTorso.add(efectoFuerza)

  // Setup Requerimientos del Equipable
  val requerimientosCasco: mutable.Set[Atributo] = mutable.Set()
  val requerimientosTorso: mutable.Set[Atributo] = mutable.Set()
  val requerimientosGuantes: mutable.Set[Atributo] = mutable.Set()
  val requerimientoArmadura: Atributo = new Atributo("Armadura", 5)
  this.requerimientosGuantes.add(requerimientoArmadura)

  // Setup del Equipable
  val tipoCasco: TipoDeItem = new TipoDeItem(4, "Casco", efectosCasco, requerimientosCasco)
  val casco: Equipamiento = new Equipamiento("Yelmo de bronce", tipoCasco, 10, 5)
  val tipoTorso: TipoDeItem = new TipoDeItem(9, "Torso", efectosTorso, requerimientosTorso)
  val torso: Equipamiento = new Equipamiento("Coraza de hierro", tipoTorso, 15, 7)
  val tipoGuantes: TipoDeItem = new TipoDeItem(5, "Guantes", efectosGuantes, requerimientosGuantes)
  val guantes: Equipamiento = new Equipamiento("Guantes de cuero", tipoGuantes, 4, 2)

  before {
    personaje.recogerItem(casco)
    personaje.recogerItem(torso)
    personaje.recogerItem(guantes)
  }

  after {
    personaje.inventario.tirarTodo()
    personaje.tirarItemEquipado(slotCasco)
    personaje.tirarItemEquipado(slotTorso)
    personaje.tirarItemEquipado(slotGuantes)
    atributoArmadura.cantidad = 0
  }

  // Equipar un ítem en el slot correspondiente

  test("AlEquiparUnCascoApareceEnElSlotCorrespondiente") {
    personaje.equiparItem(casco)
    assert(slotCasco.estaEquipado())
    assert(slotCasco.itemEquipado.equals(casco))
  }

  test("AlEquiparUnCascoNoApareceEnElInventario") {
    assert(personaje.tieneItemEnInventario(casco))
    personaje.equiparItem(casco)
    assert(!personaje.tieneItemEnInventario(casco))
  }

  test("AlEquiparUnCascoSusEfectosAfectanAlPersonaje") {
    assert(atributoArmadura.cantidad.equals(0))
    personaje.equiparItem(casco)
    assert(atributoArmadura.cantidad.equals(12))
  }

  // Se quiere equipar un Equipable con un Efecto que no coincide con los atributos del Personaje,
  // lo cual desencadena una excepsion del tipo AtributoNoEncontradoException.
  test("AlEquiparUnaCorazaDeTorsoSuEfectoNoCoincideConLosAtributosDelPersonaje") {
    assertThrows[AtributoNoEncontradoException](personaje.equiparItem(torso))
  }

  // El Personaje quiere poner un Equipable, pero no cumple con los Requerimientos de este,
  // lo cual desencadena una excepsion del tipo NoCumpleRequerimientosException.
  /*test("NoPuedeEquiparGuantesPorNoCumplirConLosRequerimientosDeEste") {
    assertThrows[NoCumpleRequerimientosException](personaje.equiparItem(guantes))
  }*/

  // Desequipar un ítem: Verificar efectos quitados, capacidad del inventario, slot disponible.

  // Tirar un ítem equipado. Verificar: Efectos quitado, capacidad del inventario, slot disponible.

}
