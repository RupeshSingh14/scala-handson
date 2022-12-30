package com.singh.rupesh
package oop

//import basics.Cindrella // comes due to defining importVal for classes from other package

object PackagingAndImports extends App{

  //package members are accessible by their simple name
  val writer = new Writer("Rupesh", "Singh", 2022)

  //importing the package
  //val importVal = new Cindrella
  val importVal1 = new basics.Cindrella // using full name, ie.. package + class

  //package object - can be only one per package
  //it is created with name package.scala and creates object with same name as package
  // we can define methods and constants that can be used inside anywhere in package
  hello
  println(myDOB)

}
