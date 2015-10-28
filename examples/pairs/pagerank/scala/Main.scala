import org.apache.spark._

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val input = sc.textFile("../input").cache
    val links = input.map(_.split(": ")).map(values => (values(0), values(1).split(", ")))

    var ranks = links.mapValues(v => 1.0)

    for (i <- 1 to 10) {
      val contribs = links.join(ranks).values.flatMap {
        case (links, rank) =>
        links.map(n => (n, rank / links.size))
      }
      val newRanks = contribs.reduceByKey(_ + _).mapValues(0.15 + 0.85 * _)
      ranks = ranks.leftOuterJoin(newRanks).mapValues {
        case (old, newValue) => newValue.getOrElse(0.15)
      }
    }
    ranks.saveAsTextFile("ranks")

  }
}
