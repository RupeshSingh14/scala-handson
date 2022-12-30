package com.singh.rupesh
package oop

abstract class GenericMyList[+A] {
  /*
     head = first element of the list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) = new list with this element added
     toString = a string representation of the list
   */

  def head: A
  def tail: GenericMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericMyList[B]
  def printElements: String  //polymorphic method
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A,B]): GenericMyList[B]
  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]) : GenericMyList[B]
  def filter(predicate: MyPredicate[A]): GenericMyList[A]

  def ++[B >: A](list: GenericMyList[B]): GenericMyList[B]

  //hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A,A) => Int): GenericMyList[A]
  def zipWith[B,C](list: GenericMyList[B], zip: (A,B) => C): GenericMyList[C]
  def fold[B] (start: B) (operator: (B,A) => B): B

}

case object Empty extends GenericMyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: GenericMyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): GenericMyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): GenericMyList[B] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, GenericMyList[B]]) : GenericMyList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = Empty

  override def ++[B >: Nothing](list: GenericMyList[B]): GenericMyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): GenericMyList[Nothing] = Empty

  override def zipWith[B, C](list: GenericMyList[B], zip: (Nothing, B) => C): GenericMyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

case class Cons[+A](h: A, t: GenericMyList[A]) extends GenericMyList[A] {
  override def head: A = h

  override def tail: GenericMyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): GenericMyList[B] = new Cons(element, this)

  override def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements


 /*
   [1,2,3].filter(n % 2 == 0)
    = [2,3].filter(n % 2 == 0)
    = new Cons(2, [3].filter(n % 2 == 0)
    = new Cons(2, Empty.filter(n % 2 == 0)
    = new Cons(2, Empty)
    = [2]
  */
  override def filter(predicate: MyPredicate[A]): GenericMyList[A] =
    if(predicate.test(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)

  /*
  [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
    = [2,4,6]
   */
  override def map[B](transformer: MyTransformer[A, B]): GenericMyList[B] =
    new Cons[B](transformer.transform(h), t.map(transformer))

  /*
   [1,2] ++ [3,4,5]
   = new Cons(1, [2] ++ [3,4,5]
   = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
   = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  override def ++[B >: A](list: GenericMyList[B]): GenericMyList[B] = new Cons[B](h, t ++ list)

  /*
   [1,2].flatMap(n => [n, n+1])
   = [1,2] ++ [2].flatMap(n => [n, n+1])
   = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
   = [1,2] ++ [2,3] ++ Empty
   = [1,2,2,3]
   */
  override def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): GenericMyList[A] = {
    def insert(x: A, sortedList: GenericMyList[A]): GenericMyList[A] = {
      if (sortedList.isEmpty) new Cons[A](x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons[A](x, sortedList)
      else new Cons[A](sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: GenericMyList[B], zip: (A, B) => C): GenericMyList[C] =
    if(list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons[C](zip(h, list.head), t.zipWith(list.tail, zip))

  /*
  [1,2,3].fold(0)(+) =
  = [2,3].fold(1)(+) =
  = [3].fold(3)(+) =
  = [].fold(6)(+)
  =6
   */
  override def fold[B](start: B)(operator: (B, A) => B): B = {
    //val newStart = operator(start, h)
    //t.fold(newStart)(operator)
    t.fold(operator(start,h))(operator)
  }




}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A) : B
}

object GenericListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)
  println(list.tail)
  println(list.tail.isEmpty)
  val listOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: GenericMyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: GenericMyList[String] = new Cons("Hello", new Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  /*
  1. Generic trait MyPredicate[-T] with a method test(T) => Boolean
  2. Generic trait MyTransformer[-A,B] with a method transform(A) => B
  3. MyList:
     - map(transformer) => new MyList
     - filter(transformer) => new MyList
     - flatMap(transformer from A to MyList[B]) => MyList[B]

  Ex -  For 1. class EvenPredicate extends MyPredicate[Int] => the provided value is int or not
        For 2. class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n => [n, n + 1]) => [1,2,2,3,3,4]

   */

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(new MyTransformer[Int, GenericMyList[Int]] {
    override def transform(element: Int): GenericMyList[Int] = new Cons[Int](element, new Cons[Int](element + 1, Empty))
  }).toString)

  // case classes demo of how equals() is auto implemented and works
  val cloneListOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listOfIntegers == cloneListOfIntegers)  // true

  //hofs
  println(listOfIntegers)
  println(listOfIntegers.head)
  println(listOfIntegers.tail)
  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x,y) => y - x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))

  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string

  println(combinations)





}
