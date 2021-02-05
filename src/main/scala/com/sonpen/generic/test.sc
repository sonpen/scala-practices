class Parent
class Child extends Parent

class Generic[A](a: A)


val g1 = new Generic[Parent](new Child)
val g2 = new Generic[List[Parent]](List(new Child))


def pickWinner[A](candidates: Seq[A]): A = {
  val randomNum = util.Random.nextInt(candidates.length)
  candidates(randomNum)
}

pickWinner(List("a", "b", "c"))
pickWinner(1 to 100)