//function calling itself

object Code17 {
 def main(args: Array[String]){
  def factorial(num: BigInt): BigInt = { 
      if(num <= 1)
      1
      else 
      num * factorial(num -1)
      } 
      println("factorial of 4 is :" + factorial(4))
}
}