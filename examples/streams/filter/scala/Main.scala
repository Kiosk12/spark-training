import org.apache.spark._
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(1))

    val input = ssc.socketTextStream("localhost", 7777)
    val output = input.filter(_.contains("teet")).map(_.capitalize)
    output.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
