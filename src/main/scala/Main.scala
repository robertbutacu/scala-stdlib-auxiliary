import cats._
import cats.data._
import cats.implicits._
import typeclasses.FilterAuxiliary
import typeclasses.RandomizerAuxiliary
import typeclasses.instances.FilterAuxiliary._
import typeclasses.instances.RandomizerAuxiliary._

import scala.util.Random

object Main extends App {
  println(List(1,2,3).filterOff(4))
  println(Option(1).filterOff(4))

  println(implicitly[Numeric[Double]].random)
  println(implicitly[Numeric[Int]].random)
  println(implicitly[Numeric[Float]].random)
}
