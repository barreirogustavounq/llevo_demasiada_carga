package LlevoDemasiadaCarga.Excepciones

final case class CantidadDeApilablesAlMaximoException(private val message:String = "No se pueden apilar mas items, pila completa",
                                                      private val cause:Throwable = None.orNull) extends Exception(message, cause)
