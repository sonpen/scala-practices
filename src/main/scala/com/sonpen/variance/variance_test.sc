// Basic Variance
abstract class Animal {
  def name: String
}
abstract class Pet extends Animal
case class Dog(name: String, age:Int) extends Pet
case class Cat(name: String, age:Int) extends Pet

class MyList[+A]
class Trainer[-A]
class Box[A]

val animal: Animal = new Dog("dog", 1)
// Covariance
val mylist1: MyList[Animal] = new MyList[Dog]
//val mylist2: MyList[Dog] = new MyList[Animal]

// Contravariance
val trainer1: Trainer[Dog] = new Trainer[Animal]
//val trainer2: Trainer[Animal] = new Trainer[Dog]  // compile error

// Invariant
val box1: Box[Animal] = new Box[Animal]
//val box2: Box[Animal] = new Box[Dog]  // complie error


// Contravarance
val dog = new Dog("Princess", 12)
val cat = new Cat("Garfield", 6)

abstract class Printer[-A] {
  def print(value: A): Unit
}
class AnimalPrinter extends Printer[Animal] {
  def print(a: Animal): Unit =
    println("Animal: " + a.name)
}
class DogPrinter extends Printer[Dog] {
  override def print(a: Dog): Unit =
    println("Dog: " + a.name)
}

def dogPrinter(p: Printer[Dog], d: Dog) = p.print(d)

val ap = new AnimalPrinter
val dp = new DogPrinter

dogPrinter(dp, dog)  // 당연히 되고
dogPrinter(ap, dog)  // 이것도 된다

// 하지만 뭔가 실제적인 예가 아니어서 쓰임새가 잘 와 닿지 않는다
