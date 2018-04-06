package LlevoDemasiadaCarga

trait Apilable
{

  val tipo : String
  var cantidad : Int
  val maximo : Int

  def aumentarPila() {cantidad += 1}
  def disminuirPila() {cantidad -= 1}
  def apilarItems(item1 : Apilable, item2 : Apilable){if(item1.tipo == item2.tipo) }
  def usarPila()
  def precioCompraPila()
  def precioVentaPila()

}
