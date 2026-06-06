ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.18"

lazy val root = (project in file("."))
  .settings(
    name := "producer-service"
  )

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "4.3.0",
  "io.circe" %% "circe-core" % "0.14.15",
  "io.circe" %% "circe-generic" % "0.14.15",
  "io.circe" %% "circe-parser" % "0.14.15",
  "org.slf4j" % "slf4j-simple" % "2.0.18"
)