package LlevoDemasiadaCarga

 trait Apilable
{

  val item : ItemBasico with Comerciable
  val tipo : TipoDeItem
  var cantidad : Int

  def aumentarPila() {if(cantidad < tipo.maximoApilable){cantidad += 1} }
  def disminuirPila() {if(cantidad > 0){cantidad -= 1}}
  def apilarItems(item1 : ItemBasico with Apilable, item2 : ItemBasico with Apilable, inventario : Inventario){ inventario.apilarItems(item1, item2)}
  def desapilarItem(pila : ItemBasico with Apilable, inventario: Inventario){inventario.desapilarItem(pila)}

   override def usar(personaje: Personaje): Unit = {
    this.disminuirPila()
    this.AplicarEfecto(personaje)
    }

   override def precioVenta: Int = item.precioVenta * cantidad

   override def precioCompra: Int = item.precioCompra * cantidad

}

