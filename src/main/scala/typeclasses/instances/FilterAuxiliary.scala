package typeclasses.instances

import cats.FunctorFilter
import typeclasses.FilterAuxiliary

import scala.language.higherKinds

object FilterAuxiliary {
  def apply[F[_]](implicit ff: FilterAuxiliary[F]): FilterAuxiliary[F] = ff

  implicit class FilterAuxiliarySugar[F[_], A](input: F[A]) {
    def filterOff(elem: A)(implicit fa: FilterAuxiliary[F], ff: FunctorFilter[F]): F[A] = fa.filterOff(input)(elem)
  }

  implicit def generalFilter[M[_]]: FilterAuxiliary[M] = new FilterAuxiliary[M] {
    override def filterOff[A](input: M[A])(elem: A)(implicit ff: FunctorFilter[M]): M[A] = ff.filter(input)(e => e != elem)

    override def filterFor[A](input: M[A])(elem: A)(implicit ff: FunctorFilter[M]): M[A] = ff.filter(input)(e => e == elem)
  }
}
