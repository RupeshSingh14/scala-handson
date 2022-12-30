package com.singh.rupesh
package oop

object CaseClasses extends App{

  /*
   equals, hashcode, toString
   Case class provides with all above 3 as well as create companion objects for the classes
   */

  case class Person(name: String, age: Int)
  // 1. class parameters are automatically promoted to fields
  val jim = new Person("Jim", 42)
  println(jim.name)

  // 2. creates sensible toString()
  println(jim.toString) //Person(Jim,42)
  println(jim)  // this will be compiled as instance.toString() as above

  // 3. equals and hashcode are auto implemented
  val jim2 = new Person("Jim", 42)
  println(jim == jim2)  // true since equals method is implemented automatically for case classes

  // 4. Case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5. Case classes have already implemented companion objects
  val thePerson = Person //companion object is called
  val mary = Person("Mary", 23) // this calls apply method of companion object which internally calls class
  // constructor. So for case classes we can call them this way without using keyword "new"

  //6. Case classes are serializable ie.. can be send easily over distributed systems over netowrk and in
  //jvms and while using Akka frameworks

  //7. Case classes have extractor patterns ie.. can be used in Pattern matching

  case object India {
    def name: String = "The 7th largest country in world"
  }

  // case objects are like case classes but they don't get companion objects as the case objects themselves
  // are companion objects

  // case classes are quick light weight data structures with little boilerplate
}