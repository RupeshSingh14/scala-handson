package com.singh.rupesh
package fp

import java.util.Random

//An option is a wrapper for a value that might be present or not.
object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  //unsafe API
  def unSafeMethod(): String = null
  //val result = Some(unSafeMethod()) // wrong implementation
  val result = Option(unSafeMethod()) //Some or None
  println(result)

  //chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethod()))

  // for designing unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterBackupMethod() orElse betterBackupMethod()

  //functions on Option
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)  //Unsafe, can throw null pointer - Do not use it

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehension
  //Ex

  //simulation of configuration file fetch from else where
  val config: Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "8080"
  )

  class Connection {
    def connect = "connected" // upon connection to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    // simulation of connection method which may or may not work
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None

  }
    //try to establish a connection, if done - print the connect method

    val host = config.get("host")
    val port = config.get("port")

  /*
  if(h != null)
    if(p != null) return Connection.apply(h,p)
   return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))
  /*
  if(c != null) return c.connect
  return null
   */
  val connectionStatus = connection.map(c => c.connect)
  // if(connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)
  // if(connectionStatus != null) println(connectionStatus)
  connectionStatus.foreach(println)


  //chained solution
  config.get("host")
    .flatMap(host =>  config.get("port")
    .flatMap(port => Connection(host, port))
    .map(connection => connection.connect))
    .foreach(println)

  //for comprehensions
  val connections = for {
    host <- config.get("host") // for given host obtained from config()
    port <- config.get("port") // for given port obtained from config()
    connection <- Connection(host, port) // for given connection from connection()
  } yield connection.connect // assuming host, port and connection are not null, give me Connection.connect else none

  connections.foreach(println)
}
