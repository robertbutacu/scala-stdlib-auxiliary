package instances

import typeclasses.RandomizerAuxiliary

object RandomizerAuxiliary {
  def apply[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): RandomizerAuxiliary[A] = randomizerAuxiliary
}
