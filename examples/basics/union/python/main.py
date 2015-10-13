from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("test")
sc = SparkContext(conf=conf)
