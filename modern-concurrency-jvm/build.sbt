
// Set the project name
name := "modern-concurrency-in-jvm"

description := "Modern Concurrency in the JVM. A quiclk overview on futures, actors, agents, STM,..."

version := "0.1"

libraryDependencies ++= Seq(
  	"com.typesafe.akka" % "akka-actor" % "2.0.2" 
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  
