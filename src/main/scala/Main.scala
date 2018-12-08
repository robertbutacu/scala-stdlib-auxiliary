import cats.{Functor, FunctorFilter, Monad}
import cats.instances.list
import cats.implicits._
import filter.FilterAuxilaries

object Main extends App {
  implicit val ffList: FunctorFilter[List] = new FunctorFilter[List] {
    override def functor: Functor[List] = Functor[List]

    override def mapFilter[A, B](fa: List[A])(f: A => Option[B]): List[B] = fa.foldLeft(List.empty[B])((acc, curr) =>
      f(curr) match {
        case None       => acc
        case Some(elem) => acc :+ elem
      }
    )
  }

  println(FilterAuxilaries[List].filterOff(List(1,2,3,4))('a'))
}
