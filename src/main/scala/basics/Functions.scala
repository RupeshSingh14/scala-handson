package com.singh.rupesh
package basics

object Functions extends App {

  def aFunction(a: String, b: Int) : String = {
    a +  " " + b
  }

  println(aFunction("Rupesh", 3))

  def aParameterlessFunction() : Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction) // this works only in scala 2
  // In scala 3, a function with parenthesis requires parenthesis while calling function and
  // a function without parenthesis does not requires parenthesis while calling function

  def aRepeatedFunction(aString: String, n: Int) : String = {
    if (n==1) aString
    else aString + " " + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Rupesh", 3))
  // When loops are required, use recursion. This is way of functional programming
  // In scala, functions return types can also be inferred by compiler if not explicitly mentioned but
  // for recursive functions we would need to specify the return type since it cannot be referred automatically

  def aFunctionWithSideEffects(aString : String ) : Unit = println(aString)
  // a function returning unit is used for something not related to computation like print statements, writing to a file

  def aBigFunction(n: Int) : Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n-1)
  }
  // a function can contain a auxiliary function within it

  /*  Exercises
   1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
   2. Factorial function  1 * 2 * 3 * 4 * .... * n
   3. A Fibonacci function
   4. To test if a number is prime
   */

  def aGreetingFunction(name: String, age: Int) : String = s"Hi, my name is $name and I am $age years old."

  println(aGreetingFunction("Rupesh", 31))

  def factorialFunction(n: Int) : Int = {
    if(n <= 0) 1 else n * factorialFunction(n-1)
  }

  println(factorialFunction(3))

  def fibonacciFunction(n: Int) : Int = {
    if(n <= 2) 1 else fibonacciFunction(n-1) + fibonacciFunction(n-2)
  }

  println(fibonacciFunction(8))

  def isPrimeFunction(n : Int) : Boolean = {
    def isPrimeUntil(t: Int) : Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n/2)
  }

  println(isPrimeFunction(11))
}
