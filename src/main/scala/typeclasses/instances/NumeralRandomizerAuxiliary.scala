package typeclasses.instances

import typeclasses.NumeralRandomizerAuxiliary

object NumeralRandomizerAuxiliary {
  def apply[A](implicit numeralRandomizerAuxiliary: NumeralRandomizerAuxiliary[A]): NumeralRandomizerAuxiliary[A] = numeralRandomizerAuxiliary

  implicit class NumeralRandomizerAuxiliaryImplicit[A](input: A) {
    def random(implicit numeralRandomizerAuxiliary: NumeralRandomizerAuxiliary[A]): A = numeralRandomizerAuxiliary.nextRandom
  }
}
