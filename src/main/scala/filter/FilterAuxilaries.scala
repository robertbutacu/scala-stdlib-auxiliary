package filter

import cats.FunctorFilter

import scala.language.higherKinds

trait FilterAuxilaries[F[_]] {
  def filterOff[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
}

object FilterAuxilaries {
  def apply[F[_]](implicit ff: FilterAuxilaries[F]): FilterAuxilaries[F] = ff

  implicit val listFilter: FilterAuxilaries[List] = new FilterAuxilaries[List] {
    override def filterOff[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] = {
      ff.filter(input)(_ != elem)
    }
  }
}
