package typeclasses

trait NumeralRandomizerAuxiliary[A] extends Fractional[A] with RandomizerAuxiliary[A] {
  def fractional: Fractional[A] = ??? /*implicitly[Fractional[A]]*/
  def numeric:    Numeric[A]    = ??? /*implicitly[Numeric[A]]*/
}