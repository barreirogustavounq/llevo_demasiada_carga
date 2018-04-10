package LlevoDemasiadaCarga
import LlevoDemasiadaCarga.Excepciones.InsuficienteEspacioException, scala.collection.mutable

class Inventario(val capacidadMaxima: Int){

  var items : mutable.Set[ItemBasico] = mutable.Set()

  def recogerItem(item: ItemBasico): Unit = {
    try {
        this.puedoAgregar(item.volumen)
        this.items += item
    }
      catch { case _ : InsuficienteEspacioException => print("No tienes suficiente espacio en el inventario.\n") }
    }

  def tirarItem(item: ItemBasico): Unit = {
    if (this.tieneItem(item)) this.items -= item
  }

  def puedoAgregar(volumenDelItem: Int): Boolean = { this.volumenDisponible() >= volumenDelItem }

  def tieneItem(item: ItemBasico):Boolean = { this.items.contains(item) }

  def volumenDisponible():Int = { this.capacidadMaxima - items.map(_.volumen).sum  }

  def verificarSiPuedeRecogerItem(volumenItem: Int): Unit = {
    if (!this.puedoAgregar(volumenItem)){ throw InsuficienteEspacioException() } }

  def tirarTodo(): Unit = {
    this.items.clear()
  }
}