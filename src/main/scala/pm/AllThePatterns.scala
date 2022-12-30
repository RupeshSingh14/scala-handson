package com.singh.rupesh
package pm

//import oop.{Cons, Empty, GenericMyList, MyList}

object AllThePatterns extends App {
/*
  // 1. Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The truth"
    case AllThePatterns => "A singleton object"
  }

  // 2. Match Anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ => "I am matching anything"
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I have found $something"
  }

  // 3 tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I have found $something"
  }

  // PMs can be nested
  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => s"Value of v is $v"
  }

  //4 case classes - constructor pattern
  // PMs can be nested with Case classes as well
  val aList: GenericMyList[Int] = Cons(1, Cons(2, Empty))
  val matchList = aList match {
    case Empty => s"This is empty"
    //case Cons(head, tail) => s"Value of head is $head and that of tail is $tail"
    case Cons(head, Cons(subhead, subTail)) => s"Value of subTail is $Cons"
  }

  //5 List Patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => //extractor - advanced PM
    case List(1, _*) => //list of arbitrary length - advanced PM
    case 1 :: List(_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }

  //6 Type specifier
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //explicit type specifier
    case _ =>
  }

  //7 name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding => we can use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  //8 multi patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi pattern)
  }

  //9 if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) => if specialElement % 2 == 0 =>
  }*/

  // in JVM, Generics is only used for type checking, and after type check in done, code
  // code run without any type in place

  // in below code List[String] and List[Int] becomes only List after type check by JVM and
  // pattern is matched for first case itself.
  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfIntegers: List[Int] => "a list of integers"
    case _ => ""
  }

  println(numbersMatch)





}
