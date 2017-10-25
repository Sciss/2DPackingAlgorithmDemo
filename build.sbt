lazy val baseName = "Packing2D"
lazy val baseNameL = baseName.toLowerCase

lazy val commonSettings = Seq(
  organization      := "de.sciss",
  version           := "0.1.0-SNAPSHOT",
  scalaVersion      := "2.12.4",
  licenses          := Seq("MIT" -> url("https://raw.githubusercontent.com/papuja/2DPackingAlgorithmDemo/master/LICENSE")),
  autoScalaLibrary  := false,   // this is just a Java project
  crossPaths        := false,   // this is just a Java project
  homepage          := Some(url(s"https://github.com/Sciss/$baseName")),
  // ---- publishing to Maven Central ----
  publishMavenStyle := true,
  publishTo := {
    Some(if (isSnapshot.value)
      "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    else
      "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
    )
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := {
    <scm>
      <url>git@github.com:Sciss/{baseName}.git</url>
      <connection>scm:git:git@github.com:Sciss/{baseName}.git</connection>
    </scm>
      <developers>
        <developer>
          <id>papuja</id>
          <name>Papuja</name>
          <url>https://github.com/papuja</url>
        </developer>
        <developer>
          <id>sciss</id>
          <name>Hanns Holger Rutz</name>
          <url>http://www.sciss.de</url>
        </developer>
      </developers>
  }
)

// ---- projects ----

lazy val root = Project(
  id            = baseNameL,
  base          = file("."),
  aggregate     = Seq(core, demo),
  dependencies  = Seq(core, demo),
  settings = commonSettings ++ Seq(
    name := baseName,
    // publishArtifact in (Compile, packageBin) := false, // there are no binaries
    // publishArtifact in (Compile, packageDoc) := false, // there are no javadocs
    // publishArtifact in (Compile, packageSrc) := false  // there are no sources
    packagedArtifacts := Map.empty
  )
)

lazy val core: Project = Project(
  id        = s"$baseNameL-core",
  base      = file("core"),
  settings  = commonSettings ++ Seq(
    name        := s"$baseName-core",
    description := "2D rectangle packing algorithms",
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
)

lazy val demo = Project(
  id        = s"$baseNameL-demo",
  base      = file("demo"),
  dependencies = Seq(core),
  settings  = commonSettings ++ Seq(
    name        := s"$baseName-demo",
    description := "Demo applications for the 2D packing algorithms",
    mainClass in (Compile,run) := Some("de.sciss.packing2d.demo.App")
  )
)
