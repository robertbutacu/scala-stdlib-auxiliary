package typeclasses

import cats.FunctorFilter

import scala.language.higherKinds

trait FilterAuxilary[F[_]] {
  def filterOff[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
  def filterFor[A](input: F[A])(elem: A)(implicit ff: FunctorFilter[F]): F[A]
}
