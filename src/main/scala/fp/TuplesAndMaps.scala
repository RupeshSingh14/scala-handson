package com.singh.rupesh
package fp

object TuplesAndMaps extends App {

  //tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "hello, scala") // Tuple2[Int, String] = (Int, String)
  val aTuple1 = Tuple2(2, "hello, scala")
  val aTuple2 = (2, "hello, scala") // all 3 formats are valid tuples
  // a tuple can have up to 22 parameters in scala
  println(aTuple._1)
  println(aTuple1._2)
  println(aTuple1.copy(_2 = "goodbye java")) // copies the string at 2nd param
  println(aTuple1.swap) // swaps the values

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789)  // a -> b is syntactic sugar for (a,b)
  val phoneBook1 = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook)

  //map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) //apply method
  println(phoneBook1("marry"))  // returns -1
  // using apply method with a key which is not available in map causes no such element error. to avoid the error we can
  // use .withDefaultValue() while defining the map

  // add a pairing
  val newPairing = "Marry" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  //functions on maps
  //maps, flatmap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))  // maps, flatmaps, filters take pairing

  //filterKeys
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap) //due to depreciation filterKeys is being used with view and toMap

  //mapValues
  println(phoneBook.view.mapValues(number => number * 10).toMap)
  println(phoneBook.view.mapValues(number => "06542-" + number).toMap)

  //conversion to other collections
  println(phoneBook.toList)
  println(List(("Rupesh", 7856)).toMap)

  //group by
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
  // Output - HashMap(J -> List(James, Jim), A -> List(Angela), M -> List(Mary), B -> List(Bob), D -> List(Daniel))

  /*
  Designing a simplified social network based on maps
  Person = String
  - add a person to the network
  - remove
  - friend (mutual)
  - unfriend

   - numbers of friends of a person
  - person with most friends
  - how many people have no friends
  - if there is a social connection between two people (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)

    network + (a -> (friendsOfA + b)) + (b -> (friendsOfB + a))
  }

  def unFriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsOfA = network(a)
    val friendsOfB = network(b)

    network + (a -> (friendsOfA - b)) + (b -> (friendsOfB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unFriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Marry
  val people = add(add(add(empty, "Bob"), "Jim"), "Marry")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Marry")
  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String) :Int =
    if(!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.view.filterKeys(k => network(k).isEmpty).size
    //network.filter(pair => pair._2.isEmpty).size
    //network.count(pair => pair._2.isEmpty)
    //network.count(_._2.isEmpty)
  }

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if(person == target) true
        else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Marry", "Jim"))
  println(socialConnection(network, "Bob", "Jim"))

}
