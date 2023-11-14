name := """play-scala-seed"""
organization := "com.ceiba"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.12"

libraryDependencies += guice
libraryDependencies += evolutions
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test

libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.1.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "5.1.0"
libraryDependencies += "com.h2database" % "h2" % "2.2.222"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.33"

libraryDependencies += ws
libraryDependencies += ehcache

libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.4.2"


libraryDependencies += jdbc % Test

libraryDependencies += "com.h2database" % "h2" % "1.4.200" % "test"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.1.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.ceiba.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.ceiba.binders._"
