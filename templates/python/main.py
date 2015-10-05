from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("test")
sc = SparkContext(conf=conf)

data = [1, 2, 3, 4, 5]
result = sc.parallelize(data).map(lambda a: a * a).reduce(lambda a, b: a + b)

print(">>>>> Result: %s" % result)
