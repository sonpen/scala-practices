package com.sonpen.closure

package otherscope {
  class Foo {
    // a method that takes a function and a string, and passes the string into
    // the function, and then executes the function
    def exec(f:String => Unit, name: String): Unit = {
      f(name)
    }
  }
}
object Closure extends App {

  var hello = "Hello"
  def sayHello(name: String) = {
    println(s"$hello, $name")
  }

  // execute sayHello from the exec method foo
  val foo = new otherscope.Foo
  foo.exec(sayHello, "Son")

  hello = "안녕하세요"
  foo.exec(sayHello, "손")

}
