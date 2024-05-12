name := "get-programming-with-scala-lesson46"

version := "0.1"

scalaVersion := "2.13.6" // quill doesn't support scala 3 yet

libraryDependencies ++= List(
  "io.getquill" %% "quill-jasync-postgres" % "4.7.3",
  "org.testcontainers" % "postgresql" % "1.19.7",
  "org.postgresql" % "postgresql" % "42.7.3",
  "ch.qos.logback"  %  "logback-classic" % "1.2.3"
)
