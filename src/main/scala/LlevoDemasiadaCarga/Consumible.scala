package LlevoDemasiadaCarga

trait Consumible extends Item{

  var cantidadDeUsos: Int

  abstract override def usar(personaje: Personaje): Unit={
    this.cantidadDeUsos -= 1
    if(this.cantidadDeUsos == 0)
    super.usar(personaje)
  }


}
