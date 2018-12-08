package instances

import cats.FunctorFilter
import typeclasses.FilterAuxilary

import scala.language.higherKinds

object FilterAuxiliaryInstances {
  def apply[F[_]](implicit ff: FilterAuxilary[F]): FilterAuxilary[F] = ff

  implicit val listFilter: FilterAuxilary[List] = new FilterAuxilary[List] {
    override def filterOff[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] = {
      ff.filter(input)(_ != elem)
    }

    override def filterFor[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] =
      ff.filter(input)(_ == elem)
  }
}
