sbtPlugin := true

name := "sbt-doge"

organization := "com.eed3si9n"

lazy val revision = System.getProperty("revision", "SNAPSHOT")
version := s"1.0-$revision"

scalaVersion := "2.10.6"

description := "sbt plugin to aggregate across crossScalaVerions for muilti-project builds"

licenses := Seq("MIT License" -> url("http://opensource.org/licenses/MIT"))

scalacOptions := Seq("-deprecation", "-unchecked")

publishMavenStyle := true

resolvers ++= Seq(
  "Curalate Ivy" at "https://maven.curalate.com/content/groups/ivy",
  "Curalate Maven" at "https://maven.curalate.com/content/groups/omnibus"
)

publishTo in Global := {
  val nexus = "https://maven.curalate.com/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/releases")
}

credentials += Credentials(Path.userHome / ".sbt" / "credentials")

lazy val showVersion = taskKey[Unit]("Show version")

showVersion := {
  println(version.value)
}

// custom alias to hook in any other custom commands
addCommandAlias("build", "; compile")
