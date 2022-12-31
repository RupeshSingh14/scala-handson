package com.singh.rupesh
package oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutsWith(person : Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person : Person): String = s"${this.name} + ${person.name}"
    def unary_! : String = s"$name, whats the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    //overloading the + operator
    //rupesh + "the rockstar" => new Person "Rupesh (the rockstar)"
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    //add an age to the person class
    //add an unary + operator => new person with the age + 1
    //+mary => mary with the age incrementer
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    //add a "learns" method in the Person class => "Rupesh learns Scala"
    //add a learnScala method, calls learns method with "Scala"
    //use it in postfix notation
    def learns(thing: String) = s"$name is learning $thing"
    def learnScala = this learns "Scala"

    //overload the apply method
    //rupesh.apply(2) => "Rupesh watched Xyz 2 times"
    def apply(n:Int) : String = s"$name watched $favoriteMovie for $n times"


  }

  val rupesh = new Person("Rupesh", "Rocketry")
  println(rupesh.likes("Rocketry"))// below is also equivalent
  println(rupesh likes "Rocketry") // infix notation = operation notation ~ a syntactic sugar
  // such operations can be only be performed on methods with one argument.

  val spandan = new Person(name = "Spandan", "The Kashmir Files")
  println(rupesh hangOutsWith spandan)
  println(rupesh + spandan) // in scala, all operators are implemented in same way

  println(1 + 2)
  println(1.+(2)) // all operators are methods(with single parameters) in scala

  //prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-  // unary prefix only works with - + ~ !

  println(!rupesh)
  println(rupesh.unary_!)

  //postfix
  //println(rupesh isAlive)

  println(rupesh.apply()) // below is equivalent
  println(rupesh()) // when compiler sees an object called like function ie.. using (), it looks for apply method
  //definition used in that particular class

  println((rupesh + "Legend").apply())
  println((rupesh+"Legend")())

  println((+rupesh).age)

  //println(rupesh learnScala)

  println(rupesh (10))
  println(rupesh.apply(5))
}
