package LlevoDemasiadaCarga
import LlevoDemasiadaCarga.Excepciones.InsuficienteEspacioException, scala.collection.mutable

class Inventario(val capacidadMaxima: Int) {

  var items: mutable.Set[ItemBasico] = mutable.Set()

  def recogerItem(item: ItemBasico): Unit = {
    if (puedoAgregar(item.volumen)) {
      this.items += item
    }
    else throw InsuficienteEspacioException()
  }

  def tirarItem(item: ItemBasico): Unit = {
    if (this.tieneItem(item)) {
      this.items -= item
    }
  }

  def puedoAgregar(volumenDelItem: Int): Boolean = {
    this.volumenDisponible() >= volumenDelItem
  }

  def tieneItem(item: ItemBasico): Boolean = {
    this.items.contains(item)
  }

  def volumenDisponible(): Int = {
    this.capacidadMaxima - items.map(_.volumen).sum
  }

  def verificarSiPuedeRecogerItem(volumenItem: Int): Unit = {
    if (!this.puedoAgregar(volumenItem)) {
      throw InsuficienteEspacioException()
    }
  }

  def tirarTodo(): Unit = {
    this.items.clear()
  }

  def apilarItems(item1: ItemBasico with Apilable, item2: ItemBasico with Apilable): Unit =
  {
    if((item1.tipo == item2.tipo) & (tieneItem(item1) & tieneItem(item2)))
      {
        items.remove(item1)
        items.remove(item2)
        var itemApilado : ItemBasico = new ItemBasico (item1.nombre, (item1.volumen *  item2.volumen)/2, item1.tipo) with Apilable{
        override var cantidad = item1.cantidad + item2.cantidad}
        items.add(itemApilado)
      }
  }

  def desapilarItem(pila: ItemBasico with Apilable): Unit =
  {
    if(pila.cantidad >= 2)
    {
      pila.disminuirPila()
      var itemDesapilado : ItemBasico = new ItemBasico(pila.nombre, (pila.volumen / pila.cantidad), pila.tipo) with Apilable{ override var cantidad = 1}
      items.add(itemDesapilado)
    }
  }
}
