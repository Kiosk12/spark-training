import java.util.*;
import org.apache.spark.api.java.*;
import org.apache.spark.*;

public class Main {
  public static void main(String[] args) {
    SparkConf conf = new SparkConf().setAppName("test").setMaster("local");
    JavaSparkContext sc = new JavaSparkContext(conf);


  }
}
