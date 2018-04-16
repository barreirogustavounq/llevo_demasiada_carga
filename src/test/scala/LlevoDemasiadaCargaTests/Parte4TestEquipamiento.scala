package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Efectos.Efecto
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable

class Parte4TestEquipamiento extends FunSuite with BeforeAndAfter {

  // Setup Personaje
  val inventario:Inventario = new Inventario(10)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)
  val slotCasco: Slot = new Slot("Casco", null)
  val atributoArmadura: Atributo = new Atributo("Armadura", 0)
  this.personaje.slotsEquipables.add(slotCasco)
  this.personaje.estatus.add(atributoArmadura)

  // Setup Efectos del Equipable
  val efectoArmadura: Efecto = new Efecto("Armadura", 12)
  val efectosCasco: mutable.Set[Efecto] = mutable.Set()
  this.efectosCasco.add(efectoArmadura)

  // Setup Requerimientos del Equipable
  val requerimientosCasco: mutable.Set[Atributo] = mutable.Set()

  // Setup del Equipable
  val tipoCasco: TipoDeItem = new TipoDeItem(4, "Casco", efectosCasco, requerimientosCasco)
  val casco: Equipamiento = new Equipamiento("Yelmo de bronce", tipoCasco, 10, 5)

  before {
    personaje.recogerItem(casco)
  }

  after {
    personaje.inventario.tirarTodo()
    personaje.tirarItemEquipado(slotCasco)
    atributoArmadura.cantidad = 0
  }

  // Equipar un ítem en el slot correspondiente

  test("AlEquiparUnItemApareceEnElSlotCorrespondiente") {
    personaje.equiparItem(casco)
    assert(slotCasco.estaEquipado())
    assert(slotCasco.itemEquipado.equals(casco))
  }

  test("AlEquiparUnItemNoApareceEnElInventario") {
    assert(personaje.tieneItemEnInventario(casco))
    personaje.equiparItem(casco)
    assert(!personaje.tieneItemEnInventario(casco))
  }

  test("AlEquiparUnItemSusEfectosAfectanAlPersonaje") {
    assert(atributoArmadura.cantidad.equals(0))
    personaje.equiparItem(casco)
    assert(atributoArmadura.cantidad.equals(12))
  }

  // Se quiere equipar un Equipable con un Efecto que no coincide con los atributos del Personaje,
  // lo cual desencadena una excepsion del tipo AtributoNoEncontradoException.

  // El Personaje quiere poner un Equipable, pero no cumple con los Requerimientos de este,
  // lo cual desencadena una excepsion del tipo NoCumpleRequerimientosException.

  // Desequipar un ítem: Verificar efectos quitados, capacidad del inventario, slot disponible.

  // Tirar un ítem equipado. Verificar: Efectos quitado, capacidad del inventario, slot disponible.

}
