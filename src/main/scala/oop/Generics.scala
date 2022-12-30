package com.singh.rupesh
package oop

object Generics extends App{

  class MyList[+A] { //traits can also be defined like this
    //use the type A
    def add[B >: A](element: B): MyList[B] = ??? // if to a list of A type elements, you add B type of elements
    //where B is supertype of A, then list will turn into list of B type
    /*
    A = Cat
    B = Animal (Dog)
     */

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A] : MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // If cat extends Animal, Does the list of cat extends a list of animals

  // 1. yes, it does. such behaviour is called covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // 2. No, such behaviour list is called invariant
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Not at all. Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  //example - when we define a cat trainer to be someone who can train many animals

  // bounded types
  class Cage[A <: Animal] (animal: A) //cage can be of sub type of animal
  val cage = new Cage(new Dog)

  class Zoo[A >: Cat] (cat: A) // zoo can be of any super type of cat
  val zoo = new Zoo(new Animal)

}
