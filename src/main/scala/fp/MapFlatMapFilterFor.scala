package com.singh.rupesh
package fp

object MapFlatMapFilterFor extends App{

  val list = List(1,2,3)
  println(list)

  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  //print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")
  // List("a1", "a2",..., "d4")

  //iterating in functional programing
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val combinationsWithColors = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + color)))
  println(combinationsWithColors)

  //foreach
  list.foreach(println)

  //for-comprehensions
  // equivalent to combinationsWithColors ¬ compiler breaks the for comprehension as above flatmaps and maps functions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  val combinationsWithColorsAndEvenFilter = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinationsWithColorsAndEvenFilter)

  for {
    n <- numbers
  } println(n)

  //above is equivalent to ¬ list.foreach(println)

  //Syntax overload ¬ below syntax is valid
  list.map { x =>
    x * 2
  }

  /*
  In order to use for comprehensions, it requires specific implementation of map, flatmap and filter as below
  map(f: A => B) => MyList[B]
  filter(p: A => Boolean) => MyList[B]
  flatMap(f: A => MyList[B]) => MyList[B]

   */








}
