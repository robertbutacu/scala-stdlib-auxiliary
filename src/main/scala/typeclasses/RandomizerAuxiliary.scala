package typeclasses

import scala.language.higherKinds
import scala.util.Random

trait RandomizerAuxiliary[N[_], A] {
  def randomGenerator: Random = new Random
  def nextRandom: A
}