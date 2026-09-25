ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.9.0"

lazy val root = (project in file("."))
  .settings(
    name := "Tarea Integradora ElPepeInc"
  )

libraryDependencies += "org.scalameta" %% "munit" % "1.0.1" % Test