package LlevoDemasiadaCarga.Excepciones

final case class NoIdentificadoException (private val message:String = "No se puede equipar, item no identificado",
                               private val cause:Throwable = None.orNull) extends Exception(message, cause)
