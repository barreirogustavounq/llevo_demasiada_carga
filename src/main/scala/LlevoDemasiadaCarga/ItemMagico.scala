package LlevoDemasiadaCarga

import LlevoDemasiadaCarga.Equipables.Equipable
import LlevoDemasiadaCarga.Equipables.TiposDeEquipables._
import LlevoDemasiadaCarga.Rareza.TipoRareza

class ItemMagico( nuevoVolumen : Int, val rareza : TipoRareza, val item : ItemBasico) extends ItemBasico(item.nombre, item.volumen) with Equipable
{
  var identificado = false

  private def modificarVolumen() = this.volumen = nuevoVolumen
  private def aumentarDaño(personaje: Personaje) = personaje.status.ataque *= 2
  private def aumentarDefensa(personaje: Personaje) = personaje.status.defensa += 20
  private def disminuirDaño(personaje: Personaje) = personaje.status.ataque /= 2
  private def disminuirDefensa(personaje: Personaje) = personaje.status.defensa -= 20

  override def equipar(personaje: Personaje): Unit =
    {
      super.equipar(personaje)
     this match
     {
       case i:Casco => this.aumentarDefensa(personaje)
       case i:ManoIzquierda => this.aumentarDefensa(personaje)
       case i:ManoDerecha => this.aumentarDaño(personaje)
       case i:Botas => this.aumentarDefensa(personaje)
       case i:Amuleto => this.aumentarDefensa(personaje)
       case i:AnilloIzquierdo => this.aumentarDefensa(personaje)
       case i:AnilloDerecho => this.aumentarDefensa(personaje)
       case i:Guantes => this.aumentarDefensa(personaje)
       case i:Cinturon => this.aumentarDefensa(personaje)
       case i:Torso => this.aumentarDefensa(personaje)
     }
    }

  override def desequipar(personaje: Personaje): Unit =
    {
      super.desequipar(personaje)
      this match
      {
        case i:Casco => this.disminuirDefensa(personaje)
        case i:ManoIzquierda => this.disminuirDefensa(personaje)
        case i:ManoDerecha => this.disminuirDaño(personaje)
        case i:Botas => this.disminuirDefensa(personaje)
        case i:Amuleto => this.disminuirDefensa(personaje)
        case i:AnilloIzquierdo => this.disminuirDefensa(personaje)
        case i:AnilloDerecho => this.disminuirDefensa(personaje)
        case i:Guantes => this.disminuirDefensa(personaje)
        case i:Cinturon => this.disminuirDefensa(personaje)
        case i:Torso => this.disminuirDefensa(personaje)
      }
    }

}
