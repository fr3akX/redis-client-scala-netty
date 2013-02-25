name := "redis-client-scala-netty"

organization := "lv.inbox"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-feature")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

libraryDependencies += "org.jboss.netty" % "netty" % "3.1.5.GA"

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

credentials += Credentials ("Sonatype Nexus Repository Manager","cody", "maris", "qwe123")

publishTo <<= version { v: String =>
  val nexus = "http://cody:8082/nexus/"
  if (v.trim.endsWith("SNAPSHOT")) 
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             
    Some("releases" at nexus + "content/repositories/releases")
}

resolvers += "Inbox.Public" at "http://cody:8082/nexus/content/groups/public/"
