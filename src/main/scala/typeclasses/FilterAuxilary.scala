package typeclasses

import cats.FunctorFilter

import scala.language.higherKinds

trait FilterAuxilary[F[_]] {
  def filterOff[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
  def filterFor[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
}

object FilterAuxilary {
  def apply[F[_]](implicit ff: FilterAuxilary[F]): FilterAuxilary[F] = ff

  implicit val listFilter: FilterAuxilary[List] = new FilterAuxilary[List] {
    override def filterOff[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] = {
      ff.filter(input)(_ != elem)
    }

    override def filterFor[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] =
      ff.filter(input)(_ == elem)
  }
}
