package com.singh.rupesh
package oop

import scala.annotation.tailrec

object OOBasics extends App {

  val person = new Person("Rupesh", 31)
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Raunak")
  person.greet()

  val author = new Writer("Ravinder", "Singh", 1985)
  val novel = new Novel("I too had a love story", 2001, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.print
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

// constructor
// class parameters and class fields are different things in scala. class parameters can be converted
// as class fields by adding keyword val or var to the parameters
class Person(name: String, val age: Int) {
// a class can have vals, vars, expressions, methods inside
  val x = 2 //fields
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name,0)  // this constructor call the primary main constructor of object instantiation
  // this constructor is ambiguous as it can be removed if we declare the main constructor as class Person(name: String, val age: Int = 0)
  def this() = this("John Doe")

}

/* Implementing a Novel and writer class

Writer: first name, lastName, year
- method fullname

Novel: name, year of release, author
- authorAge
- isWrittenBy (author)
- copy (new year of release) = new instance of Novel
 */
class Writer(firstName: String, lastName: String, val year: Int) {
  def fullName : String = firstName + " " + lastName
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int) : Novel = new Novel(name, newYear, author)
}

/* Counter class
 - receives an int value
 - method current count
 - method to increment/decrement => new Counter
 - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  } // increment of a count is being done instantiating a class for
  // immutability ie.. instances are fixed and cannot be modified inside but can be newly created

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}