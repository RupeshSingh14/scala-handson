package com.singh.rupesh
package oop

object Inheritance extends App {

  //Scala has single class inheritance - can only extend one class at a time
  class Animal {  //superclass
    val creatureType = "wild"
    //protected def eat = println("nomnom")
    def eat = println("nomnom")
  }

  class Cat extends Animal { //subclass. inherits all non private members of superclass
    // method declared as private are not accessible outside super class
    // method declared as protected are only accessible inside sub class

    def crunch = {
      eat
      println("crunch crunch")
    }

  }
  val cat = new Cat
  cat.crunch

  //constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age:Int, idCard: String) extends Person(name) // first constructor of Person(superclass) will be called followed by
  // call to Adult constructor(child class)

  //overriding
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("Crunch Crunch")
    }
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  //overriding can be done this way also
  class Dog1(override val creatureType: String) extends Animal
  val dog1 = new Dog1("domestic")
  println(dog1.creatureType)

  //type substitution ~ polymorphism
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  //preventing overrides
  //1. use final on members -  methods
  //2. use final on the entire class to prevent it from being overridden
  //3. seal the class using "Inheritance" keyword so that only other class within this file can override

}
