// Step 1: Define the blueprint
trait Inversible[A] {
  def inverse(input: A): A
}

// Stop 2: Implement instances of the type class for types desired
object InversibleInstance {
  implicit val inversibleString = new Inversible[String] {
    def inverse(input: String): String = {
      for (s <- input.reverse)
        yield {
          if (s.isUpper) s.toLower
          else s.toUpper
        }
    }
  }

  implicit val inversibleInt = new Inversible[Int] {
    def inverse(input: Int): Int = -input
  }
}

// Step 3: Defining and interface for the type class
// We could call each for the inversible methods
// 다소 나이브한 방식은..
import InversibleInstance._
inversibleString.inverse("Hello World")
inversibleInt.inverse(100)

/*
implicit class InversibleOps[A](a: A)(implicit ev: Inversible[A]) {
  def inverse: A = ev.inverse(a)
}
10.inverse
"Hello".inverse
*/
// context bound notation
implicit class InversibleOps[A: Inversible](a: A) {
  def inverse: A = implicitly[Inversible[A]].inverse(a)
}

10.inverse
"Hello".inverse
