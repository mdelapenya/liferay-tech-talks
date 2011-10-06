name := "JVM Concurrency"

version := "0.1"

scalaVersion := "2.9.1"

// junit dependency
libraryDependencies += "junit" % "junit" % "4.8" % "test"

// using this piece of configuration we ca add multiple dependencies
// libraryDependencies ++= Seq(
//	"net.databinder" %% "dispatch-google" % "0.7.8",
//	"net.databinder" %% "dispatch-meetup" % "0.7.8"	
// )
