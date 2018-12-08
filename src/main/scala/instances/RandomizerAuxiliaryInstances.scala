package instances

import typeclasses.RandomizerAuxiliary

object RandomizerAuxiliaryInstances {
  def apply[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): RandomizerAuxiliary[A] = randomizerAuxiliary
}
