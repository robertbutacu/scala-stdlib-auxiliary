package typeclasses.instances

import typeclasses.RandomizerAuxiliary

object RandomizerAuxiliary {
  def apply[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): RandomizerAuxiliary[A] = randomizerAuxiliary

  implicit class NumeralRandomizerAuxiliaryImplicit[A](input: A) {
    def random(implicit randomizerAuxiliary: RandomizerAuxiliary[A]): A = randomizerAuxiliary.nextRandom
  }
}
