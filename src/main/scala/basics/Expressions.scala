package com.singh.rupesh
package basics

object Expressions extends App {

  val x = 1 + 2  // Expression
  println(x)

  println(2 + 3 * 5)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=
  println(aVariable)

  // Instructions (do) vs Expressions (evaluate)
  val aCondition = true
  val aConditionedValue = if(!aCondition) 5 else 3  //if condition in scala is expression and not instruction unlike java like
  // if (condition) { do something; } else { do something else };
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  //Below code is imperative programming like used in java, python or C and should not be used in scala
  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

  //Everything is scala is an expression
  val aWeiredValue = (aVariable = 3)  // unit === void
  println(aWeiredValue)  // this will print () in console
  //side effects: println(), whiles, reassigning - all these are expressions returning unit.

  // code blocks
  // code block is an expression
  // The value of block is value of last expression in the block
  // values declared inside code block are bounded inside the the code block
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

}