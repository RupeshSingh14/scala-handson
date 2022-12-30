package com.singh.rupesh
package pm

object PatternEverywhere extends App {

  try {
    //code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // catches are actually matches

/*  try {
    //code
  }catch (e) {
    e match {
      case e: RuntimeException => "runtime"
      case npe: NullPointerException => "npe"
      case _ => "something else"
    }
  }*/

  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0 //Pattern matching
  } yield 10 * x

  //generators are also based on Pattern matching
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // like wise case classes, :: operators, are based on pattern matching

  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)
  // multiple value definitions based on Pattern matching

  val head :: tail = list // val list = List(1,2,3,4)
  // list matches to tail and head
  println(head)
  println(tail)

  //partial functions
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal

  //same as above
  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }

  println(mappedList)





















}