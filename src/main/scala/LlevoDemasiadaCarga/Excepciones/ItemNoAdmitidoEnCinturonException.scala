package LlevoDemasiadaCarga.Excepciones

final case class ItemNoAdmitidoEnCinturonException (private val message: String = "No se admite este item en el cinturon, solo pociones.",
                                                    private val cause: Throwable = None.orNull) extends Exception(message, cause)
