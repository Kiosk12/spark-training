name := "Spark Training"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.5.0"
libraryDependencies += "org.apache.spark" %% "spark-streaming-twitter" % "1.5.0"

initialCommands += """
  import org.apache.spark._
  import org.apache.spark.streaming._
  import StreamingContext._

  val sc = new SparkContext("local[*]", "shell")
  val ssc = new StreamingContext(sc, Seconds(1))
  """.stripMargin

cleanupCommands += """
  println("Closing the SparkContext:")
  ssc.stop()
  """.stripMargin

fork in run := true
