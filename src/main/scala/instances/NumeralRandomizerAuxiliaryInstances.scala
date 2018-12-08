package instances

import typeclasses.NumeralRandomizerAuxiliary

object NumeralRandomizerAuxiliaryInstances {
  def apply[A](implicit numeralRandomizerAuxiliary: NumeralRandomizerAuxiliary[A]): NumeralRandomizerAuxiliary[A] = numeralRandomizerAuxiliary
}
