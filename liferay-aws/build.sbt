
// Set the project name to the string 'My Project'
name := "liferay-aws"

description := "Liferay & AWS examples"

version := "0.1"

// JClouds dependencies

libraryDependencies += "org.jclouds" % "jclouds-all" % "1.1.1"

// JLine dependencies

libraryDependencies += "jline" % "jline" % "0.9.9"

// Spring dependencies

libraryDependencies ++= Seq(
	"org.springframework" % "spring-core" % "3.0.6.RELEASE",
	"org.springframework" % "spring-context" % "3.0.6.RELEASE"	
)