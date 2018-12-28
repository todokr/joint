import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.github.todokr",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Joint",
    libraryDependencies ++= Seq(
      "org.hjson" % "hjson" % "3.0.0",
      scalaTest % Test
    )
  )
