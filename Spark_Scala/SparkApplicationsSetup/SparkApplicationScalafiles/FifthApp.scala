package main.scala

package main.scala

import org.apache.spark.streaming._
import org.apache.spark.SparkContext 
import org.apache.spark.SparkContext._ 
import org.apache.spark.SparkConf 
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.SparkContext
//import org.apache.spark.SparkContext._
//import org.apache.spark.SparkConf
 
object FifthApp extends App{
val conf = new SparkConf().setAppName("HelloSpark")
val sc = new SparkContext(conf) 
//val spark =  SparkSession.builder()
//            .appName("StreamingApp-1")
//            .master("local[2]")
            //.config("spark.executor.instances",2)
            //.config("spark.driver.memory","2g")
//            .getOrCreate()
//val ssc = new StreamingContext(spark.sparkContext , Seconds(5))
val ssc = new StreamingContext(sc , Seconds(5))
//setting up receiver
val streamRDD = ssc.socketTextStream("localhost",9999)
val wordcounts = streamRDD.flatMap(line => line.toLowerCase().split(" ")).map(word => (word,1))
                  .reduceByKey((x,y) => x+y)
wordcounts.print()
//import spark.implicits._
//wordcounts.foreachRDD{rdd => rdd.toDF("word","count").show()}
ssc.start()
ssc.awaitTermination()
}