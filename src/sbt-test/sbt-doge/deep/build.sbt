val commonSettings = Seq(
  scalaVersion := "2.12.2",
  crossScalaVersions := Seq("2.11.8", "2.12.2")
)

lazy val rootProj = (project in file(".")).
  settings(commonSettings).
  enablePlugins(CrossPerProjectPlugin).
  aggregate(libProj, fooPlugin, subroot)

lazy val `subroot-server` = (project in file("subroot/subroot-server")).
  settings(commonSettings).
  settings(
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.2")
  )

lazy val `subroot-lib` = (project in file("subroot/subroot-lib")).
  settings(commonSettings)

lazy val subroot = (project in file("subroot")).
  settings(
    commonSettings
  ).aggregate(
    `subroot-server`,
    `subroot-lib`
  )

lazy val libProj = (project in file("lib")).
  settings(
    name := "foo-lib"
  ).dependsOn(`subroot-lib`)

lazy val fooPlugin =(project in file("sbt-foo")).
  settings(
    name := "sbt-foo",
    sbtPlugin := true,
    scalaVersion := "2.10.4",
    crossScalaVersions := Seq(scalaVersion.value)
  )
