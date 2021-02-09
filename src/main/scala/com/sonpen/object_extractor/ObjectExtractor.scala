package com.sonpen.object_extractor

import scala.util.Random

/**
  * https://docs.scala-lang.org/tour/extractor-objects.html
  *
  * apply method 가 argument 를 받아서 object 를 생성한다
  *
  * 반면, unapply method 는 object 를 받아서 argument 를 돌려주는 기능을 한다.
  * 이것은 pattern matching 에서 주로 사용된다.
  */
object ObjectExtractor {

  def apply(name: String): String = s"$name, ${Random.nextLong}"

  def unapply(str: String): Option[String] = {
    val ary = str.split(",")
    if (ary.tail.nonEmpty) Some(ary.head) else None
  }
}

object ObjectExtractorApp extends App {
  println(ObjectExtractor("aaa,bbb,ccc"))

  val objectExtractor = ObjectExtractor("aaa,bbb,ccc")
  objectExtractor match {
    case ObjectExtractor(name) => println(name)
    case _ => println("not matched")
  }
}
