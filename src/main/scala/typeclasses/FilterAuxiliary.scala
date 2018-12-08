package typeclasses

import cats.FunctorFilter

import scala.language.higherKinds

trait FilterAuxiliary[F[_]] {
  def filterOff[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
  def filterFor[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
}
