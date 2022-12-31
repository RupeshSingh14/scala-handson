package com.singh.rupesh
package oop

//Exceptions used in Scala comes from Java language as it is JVM specific thing
object Exceptions extends App{
  val x: String = null
  //println(x.length) // throws null pointer exception

  //val anExceptionValue = throw new NullPointerException

  //how to catch exception
  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = { // type of this value is Anyval since getInt() gives an Int value and catch gives unit
    try {
      // code that might throw error
      getInt(true)
    } catch {
      case e: RuntimeException => println("Caught a Runtime exception")
      //case e: NullPointerException => println("Caught a Runtime exception")
    } finally {
      //code that will be executed no matter what
      //finally block is optional
      //does not influence the return type of this expression val potential
      //use finally only for the side
      println("finally!")
    }
  }
  //defining custom exceptions
 /* class MyException extends Exception
  val exception = new MyException
  throw exception*/

  //crash program with OOM
  //val array = Array.ofDim(Int.MaxValue) //Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit

  //crash program with stackOverFlow
  /*def infinite: Int = 1 + infinite
  val noLimit = infinite
*/

  /*
  Pocket calculator
  - add(x,y)
  - subtract(x,y)
  -multiply(x,y)
  -divide(x,y)

  Throw
  - overflowException if add(x,y) exceeds Int.MaxValue
  - underflowException if subtract(x,y) exceeds Int.MinValue
  - MathCalculationExecption for division by 0
*/

  class OverFlowException extends RuntimeException {
    override def getMessage: String= s"The value is beyond max allowed Integer"
  }

  class UnderFlowException extends RuntimeException

  object PocketCalculator {

    def add(x: Int, y: Int) = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

  }

  println(PocketCalculator.add(Int.MaxValue, 10))





}
