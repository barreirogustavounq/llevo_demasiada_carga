package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Equipables.TiposDeEquipables._
import LlevoDemasiadaCarga.Equipables.{Equipable, ItemsEquipables, Slot}
import LlevoDemasiadaCarga.Excepciones.{NoSePuedeDesequiparException, NoSePuedeEquiparException}

class Equipo(val personaje: Personaje){
  type ItemEquipable = ItemBasico with Equipable

  var casco:Slot = new Slot
  var manoIzquierda:Slot = new Slot
  var manoDerecha:Slot = new Slot
  var botas:Slot = new Slot
  var amuleto:Slot = new Slot
  var anilloIzquierda:Slot = new Slot
  var anilloDerecha:Slot = new Slot
  var guantes:Slot = new Slot
  var cinturon:Slot = new Slot
  var torso:Slot = new Slot

  /*def puedeEquiparItem(item: ItemEquipable): Boolean =
  {
    var contador : Int = 0
    for( r <- item.requerimientos)
    {
      if(status.filter(_.eq(r.nombre)).head.cantidad >= r.cantidad){ contador + 1}
    }
    contador == item.requerimientos.size
  }*/

  private def equiparITemEnSlot(item : ItemEquipable, slot: Slot): Unit = {
    this.puedeEquipar(slot) // Chequea que no haya nada en el slot, sino salta una exception
    item.equipar(this.personaje) // Chequea que se cumplan los requerimientos y aplica todos los efectos, sino salta una exception
    slot.equiparItem(item)
    this.personaje.tirarItem(item)
  }

  private def desequiparITemEnSlot(item: ItemEquipable, slot: Slot):Unit={
    this.puedeDesequipar(slot) // Chequea que el slot no este vacio, sino salta una exception
    this.personaje.recogerItem(item) // Vuelve el item al inventario, si no hay espacio deberia tirar exception y cancelar el desequipar
    item.desequipar(this.personaje) // Manda un mensaje al item para sacar todos los efectos
    slot.desequiparItem()
  }

  private def tirarITemEnSlot(item: ItemEquipable, slot: Slot):Unit={
    this.puedeDesequipar(slot) // Chequea que el slot no este vacio, sino salta una exception
    item.desequipar(this.personaje) // Manda un mensaje al item para sacar todos los efectos
    slot.desequiparItem()
  }

  def equiparItem(item : ItemEquipable): Unit = {
    item match {
      case i:Casco => this.equiparITemEnSlot(i, this.casco)
      case i:ManoIzquierda => this.equiparITemEnSlot(i, this.manoIzquierda)
      case i:ManoDerecha => this.equiparITemEnSlot(i, this.manoDerecha)
      case i:Botas => this.equiparITemEnSlot(i, this.botas)
      case i:Amuleto => this.equiparITemEnSlot(i, this.amuleto)
      case i:AnilloIzquierdo => this.equiparITemEnSlot(i, this.anilloIzquierda)
      case i:AnilloDerecho => this.equiparITemEnSlot(i, this.anilloDerecha)
      case i:Guantes => this.equiparITemEnSlot(i, this.guantes)
      case i:ItemsEquipables.Cinturon => this.equiparITemEnSlot(i, this.cinturon)
      case i:Torso => this.equiparITemEnSlot(i, this.torso)
    }
    /*if(puedeEquiparItem(item)) {
      for(s <- slotsEquipables) {
        if(s.lugar == item.lugarDondeSeEquipa) {
          if(s.estaEquipado()) {
            inventario.recogerItem(s.itemEquipado)
            equiparITemEnSlot(item, s)
          }
          else { equiparITemEnSlot(item, s) }
        }
      }
    }*/
  }

  def desequiparItem(item: ItemEquipable): Unit = {
    item match {
      case i:Casco => this.desequiparITemEnSlot(i, this.casco)
      case i:ManoIzquierda => this.desequiparITemEnSlot(i, this.manoIzquierda)
      case i:ManoDerecha => this.desequiparITemEnSlot(i, this.manoDerecha)
      case i:Botas => this.desequiparITemEnSlot(i, this.botas)
      case i:Amuleto => this.desequiparITemEnSlot(i, this.amuleto)
      case i:AnilloIzquierdo => this.desequiparITemEnSlot(i, this.anilloIzquierda)
      case i:AnilloDerecho => this.desequiparITemEnSlot(i, this.anilloDerecha)
      case i:Guantes => this.desequiparITemEnSlot(i, this.guantes)
      case i:ItemsEquipables.Cinturon => this.desequiparITemEnSlot(i, this.cinturon)
      case i:Torso => this.desequiparITemEnSlot(i, this.torso)
    }

    /*if(slot.estaEquipado()) {
      // ToDo: Pendiente. Retirar efectos del item.
      inventario.recogerItem(slot.itemEquipado)
      tirarItemEquipado(slot)
    }*/
  }

  def tirarItemEquipado(item: ItemEquipable): Unit = {
    item match {
      case i:Casco => this.tirarITemEnSlot(i, this.casco)
      case i:ManoIzquierda => this.tirarITemEnSlot(i, this.manoIzquierda)
      case i:ManoDerecha => this.tirarITemEnSlot(i, this.manoDerecha)
      case i:Botas => this.tirarITemEnSlot(i, this.botas)
      case i:Amuleto => this.tirarITemEnSlot(i, this.amuleto)
      case i:AnilloIzquierdo => this.tirarITemEnSlot(i, this.anilloIzquierda)
      case i:AnilloDerecho => this.tirarITemEnSlot(i, this.anilloDerecha)
      case i:Guantes => this.tirarITemEnSlot(i, this.guantes)
      case i:ItemsEquipables.Cinturon => this.tirarITemEnSlot(i, this.cinturon)
      case i:Torso => this.tirarITemEnSlot(i, this.torso)
    }
  }

  def puedeEquipar(slot: Slot):Unit= if(slot.estaEquipado()) throw NoSePuedeEquiparException()

  def puedeDesequipar(slot: Slot): Unit = if(!slot.estaEquipado()) throw NoSePuedeDesequiparException()
}
