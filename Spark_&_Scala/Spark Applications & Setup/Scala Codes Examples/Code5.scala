/*Scala Code For loop to iterate through a list*/
object Code5 {
  def main(args: Array[String]) : Unit ={
    var i = 0
    val aList = List(1,2,3,4,5)
    for ( i <- aList){
   println("List items" + i)}
  }
}