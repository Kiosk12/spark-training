import java.util.*;
import org.apache.spark.api.java.*;
import org.apache.spark.*;

class Main {
  public static void main(String[] args) {
    JavaSparkContext sc = new JavaSparkContext("local[*]", "test");

    List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
    int result = sc
      .parallelize(data)
      .map(a -> a * a)
      .reduce((a, b) -> a + b);

    System.out.println(">>>>> Result: " + result);
  }
}
