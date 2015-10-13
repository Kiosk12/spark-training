import org.apache.spark._
import org.apache.spark.sql.SQLContext
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.clustering.KMeans

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

    val input = sqlCtx.jsonFile("../data/tweets/*/*")
    input.registerTempTable("tweets")
    val texts = sqlCtx.sql("SELECT text FROM tweets").map(_.getString(0))

    val tf = new HashingTF(1000)
    def featurize(s: String) =
      tf.transform(s.sliding(2).toSeq)

      val vectors = texts.map(featurize).cache
      val model =
        KMeans.train(vectors, 10, 100)

        val groups =
          texts.groupBy(t => model.predict(featurize(t)))
          groups.foreach(println)
          model.predict(featurize("test"))
  }
}
