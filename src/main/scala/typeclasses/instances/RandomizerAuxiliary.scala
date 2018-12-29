package typeclasses.instances

import typeclasses.RandomizerAuxiliary

import scala.language.higherKinds

object RandomizerAuxiliary {
  def apply[N[_], A](implicit randomizerAuxiliary: RandomizerAuxiliary[N, A]): RandomizerAuxiliary[N, A] = randomizerAuxiliary

  implicit class NumeralRandomizerAuxiliaryImplicit[N[_], A](input: N[A]) {
    def random(implicit randomizerAuxiliary: RandomizerAuxiliary[N, A]): A = randomizerAuxiliary.nextRandom
  }

  implicit def implicitNumericIntRandomizer: RandomizerAuxiliary[Numeric, Int] = new RandomizerAuxiliary[Numeric, Int] {
    override def nextRandom: Int = {
      randomGenerator.nextInt()
    }
  }

  implicit def implicitNumericDoubleRandomizer: RandomizerAuxiliary[Numeric, Double] = new RandomizerAuxiliary[Numeric, Double] {
    override def nextRandom: Double = {
      randomGenerator.nextDouble()
    }
  }

  implicit def implicitNumericFloatRandomizer: RandomizerAuxiliary[Numeric, Float] = new RandomizerAuxiliary[Numeric, Float] {
    override def nextRandom: Float = {
      randomGenerator.nextFloat()
    }
  }
}
