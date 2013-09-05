import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "kunglao"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Select Play modules
    jdbc,      // The JDBC connection pool and the play.api.db API
    //anorm,     // Scala RDBMS Library
    //javaJdbc,  // Java database API
    //javaEbean, // Java Ebean plugin
    //javaJpa,   // Java JPA plugin
    //filters,   // A set of built-in filters
    javaCore,  // The core Java API
  
    // WebJars pull in client-side web libraries
    "org.webjars" %% "webjars-play" % "2.1.0-2",
    "org.webjars" % "bootstrap" % "3.0.0",
  
    // Add your own project dependencies in the form:
    // "group" % "artifact" % "version"
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
    "com.restfb" % "restfb" % "1.6.12",

    //slick lib
    "com.typesafe.slick" %% "slick" % "1.0.0",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.h2database" % "h2" % "1.3.166"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    scalaVersion := "2.10.2"
  )

}
