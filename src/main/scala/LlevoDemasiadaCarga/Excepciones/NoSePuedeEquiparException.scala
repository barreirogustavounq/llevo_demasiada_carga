package LlevoDemasiadaCarga.Excepciones

final case class NoSePuedeEquiparException (private val message: String = "No se puede equipar el item",
                                 private val cause: Throwable = None.orNull) extends Exception(message, cause)
