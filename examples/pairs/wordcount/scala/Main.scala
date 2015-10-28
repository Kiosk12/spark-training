import org.apache.spark._

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc
    .textFile("../input")
    .flatMap {
      _.replaceAll("[\",.:()]", "")
      .toLowerCase
      .split(" ")
    }.map(_ -> 1)
    .reduceByKey(_ + _)
    .saveAsTextFile("output")

  }
}
