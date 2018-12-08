package typeclasses

import scala.util.Random

trait RandomizerAuxiliary[A] {
  def randomGenerator: Random = new Random
  def nextRandom: A
}

object RandomizerAuxiliary {
  def apply[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): RandomizerAuxiliary[A] = randomizerAuxiliary
}
