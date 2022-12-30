package com.singh.rupesh
package basics

object   DefaultArgs extends App {

  def factorialTailRec(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else factorialTailRec(n-1, n * accumulator)
  }

  println(factorialTailRec(10, 1)) // if second parameter is not specified and then default value mentioned in
  // function definition is used.

  def savePicture(format: String = "jpg", width: Int = 1080, height: Int = 1200) : Unit = println("saving pictures")
  savePicture()
  savePicture(width = 900)
  savePicture(height = 100, width = 200, format = "bmp")
  // savePicture(200) // This will throw error since compiler assumes we are passing value for format

  //pass in every leading argument before the argument you don't want to pass
  //or name the argument(s) whichever you pass
  // while naming the argument, order of values can change



}
