package com.singh.rupesh
package oop

object AnonymousClass extends App{

  abstract class Animal {
    def eat: Unit
  }

  //Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahaha")
  }

  // Above class get compiled equivalently like below
  /*
  class AnonymousClass$$anon$1 extends Animal {
    override def eat: Unit = println("hahahaha")
  }

  val funnyAnimal: Animal = new AnonymousClass$$anon$1
*/
  println(funnyAnimal.getClass) // output - class com.singh.rupesh.oop.AnonymousClass$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I be of service?")
  }

  //we can instantiate and override fields and methods on the spot
  //we need to pass the required constructor arguments if needed
  //anonymous class works for traits and classes(abstract or non abstract both)



}
