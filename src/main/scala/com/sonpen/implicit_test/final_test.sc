class Foo {
  val justVal: String = "justVal"
  final val finalVal: String = "finalVal"

  var justVar: String = "justVar"
  final var finalVar: String = "finalVar"

  finalVar = "changed finalVar" // ok
}

class Bar extends Foo {
  override val justVal: String = "override"
  //override val finalVal = "not ok"
  //override var justVar = "not ok"  // 변경 가능한 var 를 override 한다는게 make sense 하지 않음
  //override var finalVar = "not ok"

}