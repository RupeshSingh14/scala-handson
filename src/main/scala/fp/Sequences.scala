package com.singh.rupesh
package fp

object Sequences extends App {

  /*
  Sequence is very general interface for data structures that have
  - a well defined order
  - can be indexed
   */

  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.head)
  println(aSequence.tail)
  println(aSequence.reverse)
  println(aSequence(2)) // prints the value stored at index 2
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  val aRange1: Seq[Int] = 1 until 10
  aRange.foreach(println)
  aRange1.foreach(println)

  (1 to 10).foreach(x => println( x + " Hello"))

  //lists - immutable
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended1 = 42 +: aList

  val appended = aList :+ 14

  println(prepended)
  println(prepended1)
  println(appended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays - mutable in nature, can be manually constructed with predefined lengths
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  val threeElements1 = Array.ofDim[String](3)
  threeElements.foreach(println)
  threeElements1.foreach(println)

  //mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2,0)
  println(numbers.mkString(","))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers //implicit conversion from array to sequence
  println(numbersSeq) // outputs ~ ArraySeq(1, 2, 0, 4)

  //vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vectors are only better if we need to do update operation on very large size of data

}
