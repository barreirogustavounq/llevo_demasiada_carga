package LlevoDemasiadaCargaTests

import LlevoDemasiadaCarga.Equipables.ItemsEquipables.{ArmaduraEngarzable, Cinturon, EspadaCorta}
import LlevoDemasiadaCarga.Rareza.Unico
import LlevoDemasiadaCarga._
import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte6TestEquipamientosMagicos extends FunSuite with BeforeAndAfter {
  val inventario:Inventario = new Inventario(20)
  val cinturon:Cinturon = new Cinturon("Cinturon de Cuero", 3)
  val personaje:Personaje = new Personaje("Pedro", 100, 10, 5, inventario, 10, cinturon)

  var inventarioVendedor: Inventario = new Inventario(20)
  var vendedor: Vendedor = new Vendedor(inventarioVendedor)

  var espadaMagica: EspadaCorta = new EspadaCorta

  before{
    this.personaje.recogerItem(this.espadaMagica)

  }

  // Modelar los ítems equipables mágicos, permitiendo:

  // * Equiparlos cuando se pueda
  test("ElPersonajeEquipaUnaEspadaMagicaQueAumentaLaVidaMaxima")
  {
  }
  test("ElPersonajeEquipaUnCascoMagicoQueTieneDuplicadaSuDefensa") {}
  test("ElPersonajeRecogeUnaArmaduraMagicaQueTieneDisminuidoSuVolumen") {}
  test("ElPersonajeNoPuedeRecogerUnGuanteMagicoQueTieneAumentadoSuVolumen") {}

  // * Identificarlos
  test("SeUsaUnPergaminoDeIdentificacionSobreUnEquipamientoMagicoYPasaASerIdentificado") {}
  test("SeQuiereEquiparUnEquipamientoMagicoSinIdentificarYLanzaExcepsion") {}
  test("SeIdentificaUnEquipamientoMagicoYSeEquipa") {}

  // * Aquello lo que se puede hacer con un equipable común
  test("SeDesequipaUnEquipamientoMagicoYSeDeshacenSusEfectosSobreElPersonaje") {}
  test("SeTiraUnEquipamientoMagicoYSeDeshacenSusEfectosSobreElPersonaje") {}

  // Además tienen tres rarezas distintas: Raro, muy raro y único. La rareza aumenta el precio
  //del ítem. Un ítem raro tiene el doble del precio de un ítem normal equivalente. Un ítem
  //muy raro tiene el triple, y un ítem único, el quíntuple.

  // * Rarezas
  test("UnaEspadaMagicaRaraValeElDobleQueUnaComun") {}
  test("UnGuanteMuyRaroValeElTripleQueUnoComun") {}
  test("UnaArmaduraUnicaValeElQuintupleQueUnoComun") {}

}
