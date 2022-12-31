package com.singh.rupesh
package basics

object CBNvsCBV extends App {

  // In call by value, first value is evaluated and then same value is replaced wherever a variable is used
  def calledByValue(x: Long) = {
    println("by value: " + x) // x = 906338770408500
    println("by value: " + x) // x = 906338770408500
  }

  // In call by name (x: => Long), value is only lazy evaluated ie..each time wherever referenced, computation is performed
  def calledByName(x: => Long) : Unit = {
    println("by name: " + x) // x = System.nanoTime()
    println("by name: " + x) // x = System.nanoTime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite() : Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(14, infinite()) // since parameter passed as infinite() is a lazy evaluated parameter for printFirst,
  // it is never evaluated as it is never referenced for any computation on printFirst() method.
  printFirst(infinite(), 14) // since this will go to a recursive loop, it will crash with stack overflow.

}
