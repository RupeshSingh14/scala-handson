package com.singh.rupesh
package fp

/*
Scala incorporates functions to enable pure functional programming ie.. use functions as like plain data types and treat them as
first citizens ie.. pass them as parameters and use them as values
Scala has inbuilt out of box 22 defined functions (function1 to function 22) support ie.. can take up-to 22 params, to enable
functional programming. So we do not explicitly define a class or trait and put a method and then call it like above.
 */
object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  val stringTOIntConverter = new Function1[String, Int] {
    override def apply(string : String): Int = string.toInt
  }

  println(stringTOIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] { // type of adder : (Int, Int) => Int
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // function types for Function2[A,B,R] === (A,B) => R
  // ALL SCALA FUNCTIONS ARE OBJECTS OR INSTANCES OF CLASSED DERIVING FROM FUNCTION1 TO FUNCTION22

  //a function that takes 2 strings and concatenates them
  val concatStrings = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatStrings("Rupesh", " Singh"))
  //check video and update the genericMyList methods

  //define a function which takes an int and returns another functions which takes an int and returns an int and returns an int
  // what's the type of this functions and how to do it

  // Higher order functions - functions which receive a function as a parameter or return a function as a result
  //Function1[Int, Function1[Int, Int]]
  val superAdderFunction = new Function[Int, (Int) => Int] {
    override def apply(x: Int): Int => Int = (y: Int) => x + y   // (y: Int) => x + y ~ override def apply(y: Int): Int = x + y
  }

  val adder1 = superAdderFunction(3)
  println(adder1(4))

  println(superAdderFunction(3)(4))  // curried function


}
// a standard generic function
trait MyFunction[A, B] {
  def apply(element: A) : B
}

// how we write a function
class Action1 {
  def execute(element: Int) : String = ???
}

//how we make it generic
trait Action[A, B] {
  def execute(element: A) : B
}
