package typeclasses

trait NumeralRandomizerAuxiliary[A] extends Fractional[A] with RandomizerAuxiliary[A] {
  def fractional: Fractional[A] = implicitly[Fractional[A]]
  def numeric:    Numeric[A]    = implicitly[Numeric[A]]
}

object  NumeralRandomizerAuxiliary {
  def apply[A](implicit numeralRandomizerAuxiliary: NumeralRandomizerAuxiliary[A]): NumeralRandomizerAuxiliary[A] = numeralRandomizerAuxiliary
}
