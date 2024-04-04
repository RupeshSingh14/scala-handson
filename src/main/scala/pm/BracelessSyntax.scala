//package com.singh.rupesh
//package pm
//
//object BracelessSyntax extends App{
//
//  // if expressions
//  val anIfExpression = if (2 > 3) "bigger" else "smaller"
//
//  // java style
//  val anIfExpressionV2 =
//    if (2 > 3) {
//      "bigger"
//    } else {
//      "smaller"
//    }
//
//  // compact
//  val anIfExpressionV3 =
//    if (2 > 3) "bigger"
//    else "smaller"
//
//  // scala 3
//  val anIfExpressionV4 =
//    if 2 > 3 then // if followed by brace less condition and then
//      "bigger" //higher indentation than the if part
//    else
//      "smaller"
//
//  val anIfExpressionV5 =
//    if 2 > 3 then
//      val result = "bigger"
//      result
//    else
//      val result = "smaller"
//      result
//
//  //scala one liner
//  val anIfExpressionV6 = if 2 > 3 then "bigger" else "smaller"
//
//  // for comprehensions
//  val aForComprehension = for {
//    n <- List(1,2,3)
//    s <- List("black", "white")
//  } yield s"$n$s"
//
//  // scala 3
//  val aForComprehensionV2 =
//    for
//      n <- List(1,2,3)
//      s <- List("black", "white")
//    yield s"$n$s"
//
//  // pattern matching
//  val meaningOfLife = 42
//  val aPatternMatch = meaningOfLife match {
//    case 1 => "the one"
//    case 2 => "double or nothing"
//    case _ => "something else"
//  }
//
//  // scala 3
//  val aPatternMatch = meaningOfLife match
//    case 1 => "the one"
//    case 2 => "double or nothing"
//    case _ => "something else"
//
//  // or like this too
//  val aPatternMatch =
//    meaningOfLife match
//      case 1 => "the one"
//      case 2 => "double or nothing"
//      case _ => "something else"
//
//  // methods without braces
//  def computeMeaningOfLife(arg: Int): Int =
//    val partialResult = 40
//
//
//    partialResult + 2
//
//
//  //class definition with significant indentation (same for traits, objects, enums etc)
//  class Animal:  //colon token which indicates that class definition starts from here
//    def eat(): Unit =
//      println("I am eating")
//    end eat // indented end followed by method name marks the end of this method
//
//
//    def grow(): Unit =
//      println("I am growing")
//
//    // if there are many lines of code and readability is not easy, add end token followed by class name to mark the end of class
//  end Animal // for if, match, for, methods, classes, traits, enums, objects
//
//
//  // anonymous classes
//  val aSpecialAnimal = new Animal:
//    override def eat(): Unit = println("I am special")
//
//  //indentation = strictly larger indentation
//
//  def main(args: Array[String]): Unit = {
//    println(anIfExpressionV5)
//  }
//
//}
