package LlevoDemasiadaCarga.Excepciones

final case class NoCumpleRequerimientosException(private val message: String = "No cumple los Requerimientos para equipar este Item.",
                                                 private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}
