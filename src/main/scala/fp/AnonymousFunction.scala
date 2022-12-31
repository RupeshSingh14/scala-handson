package com.singh.rupesh
package fp

object AnonymousFunction extends App {

  //anonymous function or lambda
  val doubler = (x: Int) => x * 2 // defining function type
  val doubler1: Int => Int = x => x * 2 // defining data type for variable

  // multiple params in lambda
  val adder = (x: Int, y: Int) => x + y
  val adder1: (Int, Int) => Int = (x,y) => x + y

  // no params
  val justDoSomething = () => 3

  println(justDoSomething)  // prints function itself
  println(justDoSomething()) // call the function

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntatic sugar
  val niceIncrementer: Int => Int = x => x + 1
  val niceIncrementer1: Int => Int = _ + 1 // same syntax as above

  val niceAdder: (Int, Int) => Int = (a,b) => a + b
  val niceAdder1: (Int, Int) => Int = _ + _  // same as above

  // lambdas for Higher order functions
  val superAdd = (x:Int) => (y:Int) => (x + y)
  println(superAdd(3)(4))






}
