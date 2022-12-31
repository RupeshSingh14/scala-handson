package com.singh.rupesh
package oop

object AbstractDataTypes extends App{

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Golden Retriever" // keyword override is not mandatory here
    override def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Coldblooded

  class Crocodile extends Animal with Carnivore with Coldblooded {
    override val creatureType: String = "reptile"

    override def eat: Unit = "nomnom"

    override def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  //1. both can have abstract as well as full declared values and methods
  //2. traits do not have constructor parameters
  //3. multiple traits may be inherited by same class
  //4. traits are used to describe behaviour whereas abstract class are used to describe things

}




