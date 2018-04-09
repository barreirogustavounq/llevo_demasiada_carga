package LlevoDemasiadaCarga
import LlevoDemasiadaCarga.Excepciones.InsuficienteEspacioException, scala.collection.mutable

class Inventario(val capacidadMaxima: Int){

  var volumenCargado: Int = 0
  var items : mutable.Set[Item] = mutable.Set()

  def recogerItem(item: Item): Unit = {
    try {
        this.verificarSiPuedeRecogerItem(item.volumen)
        this.items += item
        this.volumenCargado += item.volumen
        item.guardarEn(this)
    }
      catch { case _ : InsuficienteEspacioException => print("No tienes suficiente espacio en el inventario.\n") }
    }


  def tirarItem(nombreItem: String): Unit = {
    try {
      var itemATirar: Item = items.find((p:Item) => p.nombre.equals(nombreItem)).get
      this.items -= itemATirar
      this.volumenCargado -= itemATirar.volumen
      itemATirar.tirar()
    }
    catch  { case _: NoSuchElementException => print(s"No se encuentra el Item $nombreItem a tirar.\n") }
    }


  def puedoAgregar(volumenDelItem: Int): Boolean = { this.volumenDisponible() >= volumenDelItem }

  def tieneItem(item: Item):Boolean = { this.items.contains(item) }

  def volumenDisponible():Int = { this.capacidadMaxima - volumenCargado }

  def verificarSiPuedeRecogerItem(volumenItem: Int): Unit = {
    if (!this.puedoAgregar(volumenItem)){ throw InsuficienteEspacioException() } }

  def tirarTodo(): Unit = {
    this.volumenCargado = 0
    this.items.clear()
  }
}