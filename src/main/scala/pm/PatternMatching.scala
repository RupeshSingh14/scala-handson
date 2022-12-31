package com.singh.rupesh
package pm

import scala.util.Random

//switch on steroids
object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // WILDCARD
  }

  println(x)
  println(description)

  //Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hello, I am $n and I can't get married at age of $a"
    case Person(n, a) => s"Hi, I am $n and I am $a years of age."
    case _ => "I don't know who I am"
  }

  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match? Matcherror
  3. type of pattern matching expression? unified type of all the types in all the cases ie.. usually String, but if different type of
  values are in different cases, Any is the type
  4. Pattern matching works really well with case class like extractor pattern
   */

  //PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Golden Retriever")
  animal match {
    case Dog(breed) => println(s"Match of dog of breed $breed")
  }

  val isEvenCond = if(x % 2 == 0) true else false //should avoid such extra conditions
  val isEVenNormal = x % 2 == 0 // this itself returns boolean

  /*
  Exercise
  simple function uses PM, takes an expr => human readable form

  Sum(Number(2), Number(3)) => 2 + 3
  Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
  Prod(Sum(Number(2), Number(1)), Number(3)) => (2 + 1) * 3
  Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParenthesis(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParenthesis(e1) + " * " + maybeShowParenthesis(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))

}
