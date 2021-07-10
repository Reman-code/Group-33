name := """groupcs33"""
organization := "com.group33"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

//new 
libraryDependencies ++= Seq(
  jdbc
)
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

//new
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.41"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.group33.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.group33.binders._"
