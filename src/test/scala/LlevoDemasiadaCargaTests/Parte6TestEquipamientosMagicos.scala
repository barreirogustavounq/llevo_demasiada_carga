package LlevoDemasiadaCargaTests

import org.scalatest.{BeforeAndAfter, FunSuite}

class Parte6TestEquipamientosMagicos extends FunSuite with BeforeAndAfter {

  // Modelar los ítems equipables mágicos, permitiendo:

  // * Equiparlos cuando se pueda
  test("ElPersonajeEquipaUnaEspadaMagicaQueAumentaLaVidaMaxima") {}
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
