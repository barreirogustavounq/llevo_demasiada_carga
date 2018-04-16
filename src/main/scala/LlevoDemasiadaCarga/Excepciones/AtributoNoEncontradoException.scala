package LlevoDemasiadaCarga.Excepciones

final case class AtributoNoEncontradoException(private val message: String = "No se encuentra un Efecto para este Atributo.",
                                               private val cause: Throwable = None.orNull) extends Exception(message, cause) {

}
