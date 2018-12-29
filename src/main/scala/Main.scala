import cats._
import cats.data._
import cats.implicits._
import typeclasses.FilterAuxiliary
import typeclasses.instances.FilterAuxiliary._

object Main extends App {
  println(List(1,2,3).filterOff(4))

}
