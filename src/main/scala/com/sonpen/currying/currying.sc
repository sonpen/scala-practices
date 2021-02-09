// currying
def mul(x: Int, y:Int) = x * y
def mulOneAtATime(x: Int) = (y: Int) => x * y
def mulOneAtATime2(x: Int)(y: Int) = x * y // syntactic sugar

mul(2,3)
mulOneAtATime(2)(3)
mulOneAtATime2(2)(3)


def finalBill(vat: Double)(tip: Double)(amt: Double) =
  (amt*vat/100) + (amt*tip/100) + amt

val KoreaBill = finalBill(10)(0)(_)
val USABill = finalBill(10)(20)(_)

KoreaBill(10000)
USABill(10000)


