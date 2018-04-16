package LlevoDemasiadaCarga.Efectos

import LlevoDemasiadaCarga._

class Efecto(var nombreAtributo: String, var cantidad: Int) {

  // Aplica este Efecto sobre un Atributo.
  def aplicar(atributo: Atributo): Unit = atributo.cantidad += this.cantidad

  // Retira este Efecto sobre un Atributo.
  def retirar(atributo: Atributo): Unit = atributo.cantidad -= this.cantidad

}
