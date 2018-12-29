package typeclasses.instances

import typeclasses.RandomizerAuxiliary

object RandomizerAuxiliary {
  def apply[A](implicit randomizerAuxiliary: RandomizerAuxiliary[A]): RandomizerAuxiliary[A] = randomizerAuxiliary

  implicit class NumeralRandomizerAuxiliaryImplicit[A](input: A) {
    def random(implicit randomizerAuxiliary: RandomizerAuxiliary[A]): A = randomizerAuxiliary.nextRandom
  }

  def implicitDoubleRandomizer: RandomizerAuxiliary[Double] = new RandomizerAuxiliary[Double] {
    override def nextRandom: Double = randomGenerator.nextDouble()
  }

  def implicitIntRandomizer: RandomizerAuxiliary[Int] = new RandomizerAuxiliary[Int] {
    override def nextRandom: Int = randomGenerator.nextInt()
  }

  def implicitFloatRandomizer: RandomizerAuxiliary[Float] = new RandomizerAuxiliary[Float] {
    override def nextRandom: Float = randomGenerator.nextFloat()
  }
}
