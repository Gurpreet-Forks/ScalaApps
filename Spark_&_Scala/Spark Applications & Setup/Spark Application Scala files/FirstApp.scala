package main.scala

import org.apache.spark.SparkContext 
import org.apache.spark.SparkContext._ 
import org.apache.spark.SparkConf 

object FirstApp {
def main(args: Array[String]) {
val x = "abc1.txt"
val conf = new SparkConf().setAppName("HelloSpark").setMaster("local")
//val conf = new SparkConf().setAppName("HelloSpark")
val sc = new SparkContext(conf)
val y = sc.textFile(x).cache()
val counts = y.flatMap(line => line.split(" "))
                 .map(word => (word, 1))
                 .reduceByKey(_ + _)
counts.saveAsTextFile("sparkoutpt" + java.util.UUID.randomUUID.toString)
sc.stop()
}}