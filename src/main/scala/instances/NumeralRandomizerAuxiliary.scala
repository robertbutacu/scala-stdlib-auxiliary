package instances

import typeclasses.NumeralRandomizerAuxiliary

object NumeralRandomizerAuxiliary {
  def apply[A](implicit numeralRandomizerAuxiliary: NumeralRandomizerAuxiliary[A]): NumeralRandomizerAuxiliary[A] = numeralRandomizerAuxiliary
}
