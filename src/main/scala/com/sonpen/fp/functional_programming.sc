val fcat = (a: String, b:String) => a + b
fcat("hell", "world")


// Functions with function parameters
def half(f: (Double) => Double): Double = f(0.5)
half(scala.math.ceil _)
half(scala.math.sqrt _)

half(3 * _)

(1 to 9).map(0.1 * _)
(1 to 9).reduceLeft(_+_)

(1 to 9).filter(_ % 2 == 0).map(0.1 * _)
for (i <- 1 to 9 if i % 2 == 0) yield 0.1*i

def mulBy(factor: Double) = (x: Double) => x * factor
def quintuple = mulBy(5)
quintuple(20)
def triple = mulBy(3)
triple(20)


