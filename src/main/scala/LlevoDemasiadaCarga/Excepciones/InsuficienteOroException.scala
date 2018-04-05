package LlevoDemasiadaCarga.Excepciones

final case class InsuficienteOroException(private val message: String = "No tienes suficiente oro.\n",
                                 private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
