package com.singh.rupesh
package basics

object Recursion extends App {

 def factorial(n: Int) : Int = {
   if(n <= 1) 1 else {
     println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
     val result = n * factorial(n-1) // each call to recursive function uses a new stack frame
     println("Computed factorial of " + n)

     result
   }
 }
  println(factorial(10))
  // println(factorial(5000)) //this will cause Stack over flow error since it will lead to create many new stack frames to store intermediate
  //values of each recursive function


  def anotherFactorial(n: Int) : Int = {
    //@tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else {
        println("value of x = " + x + " and that of accumulator = " + accumulator)
        factHelper(x - 1, x * accumulator) // Here the current stack frame value is swapped with some other with help of accumulator
      }
        // This is called TAIL RECURSION ~ using recursive calls as the LAST expression on each code path that occurs.
        //we can use annotation @tailrec over methods which should be tailrec and if such methods are not implemented in tail recursive way,
        //compiler will flag the error
        // When loops are required, use tail recursion
    }
    factHelper(n, 1)
  }

  println(anotherFactorial(10))

  /* anotherFactorial(10) = factHelper(10,1)
     = factHelper(9, 10 * 1)
     = factHelper(8, 9 * 10 * 1)
     = factHelper(7, 8 * 9 * 10 * 1)
     = factHelper(6, 7 * 8 * 9 * 10 * 1)
     = . . .
     = factHelper(1, 1 * 2 * 3 * . . . * 10)
     = 1 * 2 * 3 * . . . * 8 * 9 * 10)
   */

  def concatFunction(word: String, n: Int, accumulator: String) : String = {
    if (n <= 0) accumulator
    else {
      println("value of word = " + word + " and that of accumulator = " + accumulator)
      concatFunction(word,n-1, word + accumulator)
    }
  }

  println(concatFunction(" hello", 5, " "))

  def primeFunction(n: Int) : Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec( t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(n/2, true)
  }

  println(primeFunction(23))
  println(primeFunction(28))

  def fibonacci(n: Int): Int = {
    // rule of thumb is how many recursive calls we have in same code path, that is how many accumulators we need to have in tail recursive.
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i+1, last + nextToLast, last)

    if(n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))

}

