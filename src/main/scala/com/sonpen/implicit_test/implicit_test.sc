abstract class Monoid[A] {
  def add(x: A, y: A): A
  def unit: A
}

implicit val stringMonoid: Monoid[String] = new Monoid[String] {
  override def add(x: String, y: String): String = x concat y
  override def unit: String = ""
}

implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
  override def add(x: Int, y: Int): Int = x + y
  override def unit: Int = 0
}

def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
  if (xs.isEmpty) m.unit
  else m.add(xs.head, sum(xs.tail))

def sum2[A](xs: A*)(implicit m: Monoid[A]): A =
  if (xs.isEmpty) m.unit
  else m.add(xs.head, sum2(xs.tail: _*))

println(sum(List(1,2,3)))
println(sum(List("a", "b", "c")))

sum2(1)
sum2(1,2,3)
sum2("a", "b", "c")



/// 바뀔수 있는게 2개 라면 Error 나네..
implicit class MyClass(i: Int) {
  def foo = println("MyClass")
}
/*
implicit class YourClass(i: Int) {
  def foo = println("YourClass")
}*/

10.foo