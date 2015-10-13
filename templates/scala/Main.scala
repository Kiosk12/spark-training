import org.apache.spark._

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val data = Seq(1, 2, 3, 4, 5)
    val result = sc
      .parallelize(data)
      .map(a => a * a)
      .reduce((a, b) => a + b)

    println(">>>>> Result: " + result)
  }
}
