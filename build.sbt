name := "scala-stdlib-auxiliary"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions += "-Ypartial-unification"
libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.4.0",
  "org.scalaz" %% "scalaz-zio" % "0.3.1",
  "org.typelevel" %% "cats-effect" % "1.0.0",
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)
libraryDependencies += "org.scalamock" %% "scalamock" % "4.0.0" % Test
