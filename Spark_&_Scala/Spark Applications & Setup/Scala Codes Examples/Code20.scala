import scala.collection.mutable.ArrayBuffer

object Code20 {
 def main(args: Array[String]){
   val favNumsx = new ArrayBuffer[Int]() 
   favNumsx += 11
   favNumsx += 2
   favNumsx ++= Array(23,34,45)
   favNumsx += (23,45,56)
   favNumsx.insert(8,100)
   favNumsx.mkString(",").foreach(print)
   println("\nremoving element\n")
   favNumsx.remove(0,1)
      //printing a specific index
	println(favNumsx(0))
      //printing array 
      favNumsx.foreach(println) 
   for(i <- 0 to favNumsx.length -1){
     favNumsx(i) = i 
     println(favNumsx(i))}
}
}