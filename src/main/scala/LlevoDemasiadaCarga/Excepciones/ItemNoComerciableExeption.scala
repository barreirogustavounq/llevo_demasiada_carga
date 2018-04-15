package LlevoDemasiadaCarga.Excepciones

class ItemNoComerciableExeption (
                                  private val message: String = "No se puede comerciar este Item",
                                  private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
