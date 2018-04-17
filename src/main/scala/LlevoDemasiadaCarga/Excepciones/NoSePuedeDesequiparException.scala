package LlevoDemasiadaCarga.Excepciones

final case class NoSePuedeDesequiparException(private val message:String = "No se puede desequipar el item, slot vacio",
                                              private val cause:Throwable = None.orNull) extends Exception(message, cause)
