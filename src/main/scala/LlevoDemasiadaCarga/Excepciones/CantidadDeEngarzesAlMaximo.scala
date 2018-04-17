package LlevoDemasiadaCarga.Excepciones

final case class CantidadDeEngarzesAlMaximo(private val message:String = "No se pueden engarzar mas items, slots llenos",
                                             private val cause:Throwable = None.orNull) extends Exception(message, cause)
