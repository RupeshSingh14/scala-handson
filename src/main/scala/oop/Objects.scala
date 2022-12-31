package com.singh.rupesh
package oop

object Objects extends App {

  //Scala does not have class level functionality like access static final constants declared in a class
  //from somewhere else in code instead it uses objects which can have constants, methods but can not contain
  //any parameter in definition

  // static class level functionality
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def from(mother: Person, father: Person): Person = new Person("Bobby") // standard is to use apply
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  // instance level functionality
  class Person(val name: String) {
    // def, blocks, vals, vars
  }

  //class and object of same type are called companions and are defined in same scope together
  //so that they can be accessed in whatever way we want. This is called companion design pattern

  println(Person.N_EYES)
  println(Person.canFly)

  //scala object = singleton instance ~ object is of type Person and also the only instance of it.
  val mary = Person
  val john = Person
  println(mary == john)

  val mary1 = new Person("mary")
  val john1 = new Person("john")
  println(mary1 == john1)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  //val bobbie = Person.from(mary1, john1)
  val bobbie = Person (mary1, john1) // Easy way of Person.apply(mary1, john1)
  println(bobbie.name)

  //A scala application is a scala object with
  // def main(args: Array[String]) : Unit
  // this is because it has to convert to an executable jvm application to run
  // like java public static void main( String[] args) {}
  // or use extends App which uses the same def main method internally
}
