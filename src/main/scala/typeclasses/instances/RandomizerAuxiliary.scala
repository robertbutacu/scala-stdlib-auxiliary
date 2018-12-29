package typeclasses.instances

import typeclasses.RandomizerAuxiliary

import scala.language.higherKinds

object RandomizerAuxiliary {
  def apply[N[_]](implicit randomizerAuxiliary: RandomizerAuxiliary[N]): RandomizerAuxiliary[N] = randomizerAuxiliary

  implicit class NumeralRandomizerAuxiliaryImplicit[N[_]](input: N[_]) {
    def random[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): A = randomizerAuxiliary.nextRandom
  }
}
