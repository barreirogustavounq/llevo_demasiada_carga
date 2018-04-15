package LlevoDemasiadaCarga.Excepciones

final case class DifenteTipoException(
                                               private val message: String = "El item que quiere apilar no es del mismo tipo que la pila.",
                                               private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
