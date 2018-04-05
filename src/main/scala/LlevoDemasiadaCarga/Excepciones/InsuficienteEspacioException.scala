package LlevoDemasiadaCarga.Excepciones

final case class InsuficienteEspacioException(
                                               private val message: String = "No tienes suficiente espacio en el inventario.\n",
                                               private val cause: Throwable = None.orNull)
                                              extends Exception(message, cause)
