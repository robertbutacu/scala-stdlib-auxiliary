package instances

import cats.FunctorFilter
import typeclasses.FilterAuxiliary

import scala.language.higherKinds

object FilterAuxiliary {
  def apply[F[_]](implicit ff: FilterAuxiliary[F]): FilterAuxiliary[F] = ff

  implicit class FilterAuxiliarySugar[F[_], A](input: F[A]) {
    def filterOff(elem: A)(implicit fa: FilterAuxiliary[F], ff: FunctorFilter[F]): F[A] = fa.filterOff(input)(elem)
  }

  implicit val listFilter: FilterAuxiliary[List] = new FilterAuxiliary[List] {
    override def filterOff[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] = {
      ff.filter(input)(_ != elem)
    }

    override def filterFor[A](input: List[A])(elem: A)(implicit ff: FunctorFilter[List]): List[A] =
      ff.filter(input)(_ == elem)
  }
}
