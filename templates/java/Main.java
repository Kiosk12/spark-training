import java.util.*;
import org.apache.spark.api.java.*;
import org.apache.spark.*;

public class Main {
  public static void main(String[] args) {
    SparkConf conf = new SparkConf().setAppName("test").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);

    List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
    int result = sc
      .parallelize(data)
      .map(a -> a * a)
      .reduce((a, b) -> a + b);

    System.out.println(">>>>> Result: " + result);
  }
}
