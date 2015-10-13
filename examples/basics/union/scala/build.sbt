name := "Spark Training"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.0"

initialCommands += """
  val sc = new org.apache.spark.SparkContext("local[*]", "shell")
  """.stripMargin

cleanupCommands += """
  println("Closing the SparkContext:")
  sc.stop()
  """.stripMargin

fork in run := true
