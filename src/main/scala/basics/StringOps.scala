package com.singh.rupesh
package basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(0,5))
  println(str.split(" ").toList)
  println(str.startsWith("He"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  // scala exclusive string operations
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println(aNumber.isValidInt)
  println("a" +: aNumberString :+ "z")
  println(str.reverse)
  println(str.take(4))

  // s-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old."
  println(anotherGreeting)

  // f-interpolators
  val speed = 123.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)
  println(f"$name%s can eat $speed%2.3f burgers per minute")

  //raw-interpolators
  println(raw"This is a \n newline") // this does not lets escape sequences to function
  val escaped = "This is a \n newline"
  println(raw"$escaped") // however it wont work this way and escape sequences will do work








}
