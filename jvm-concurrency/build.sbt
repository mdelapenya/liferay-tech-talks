name := "JVM Concurrency"

version := "0.1"

scalaVersion := "2.9.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

// junit dependency

libraryDependencies += "junit" % "junit" % "4.8" % "test"

// akka dependencies

libraryDependencies ++= Seq(
	"se.scalablesolutions.akka" % "akka-actor" % "1.2",
	"se.scalablesolutions.akka" % "akka-stm" % "1.2"	
 )
