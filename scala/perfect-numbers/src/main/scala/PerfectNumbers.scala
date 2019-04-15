object PerfectNumbers {

  def classify(number: Int): Either[String, NumberType.Value] = {
    if (number <= 0) Left("Classification is only possible for natural numbers.")
    else {
      val factorSum = (1 until number).filter(number % _ == 0).sum
      factorSum match {
        case e if factorSum == number => Right(NumberType.Perfect)
        case e if factorSum > number => Right(NumberType.Abundant)
        case e if factorSum < number => Right(NumberType.Deficient)
      }
    }
  }
}

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}