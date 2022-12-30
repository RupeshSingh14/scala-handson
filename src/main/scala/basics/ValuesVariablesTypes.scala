package com.singh.rupesh
package basics

import java.security.KeyStore.TrustedCertificateEntry

object ValuesVariablesTypes extends App {

  val x: Int = 20
  println(x)
  // An immutable value is declared as val

  val x1 = 21
  println(x1)
  //compiler can infer types

  val aString : String = "Rupesh"; println(aString)
  // semicolons are not necessary unless we write multiple statements in same line (which is bad practise)

  val aBoolean: Boolean = true
  val aChar: Char = 'R'
  val anInt: Int = 123
  val aShort: Short = 12345
  val aLong: Long = 1234556776544333333L
  val aFloat: Float = 2.1f
  val aDouble: Double = 3.141
  // A data types are similar to java. difference is nothing is primitive here

  var aVariable: Int = 2
  aVariable = 4
  // A variable is declared using var. They are known as side effects in functional programming

}
