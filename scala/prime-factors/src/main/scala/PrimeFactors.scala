import scala.annotation.tailrec

object PrimeFactors {

  def factors(number: Long): List[Int] = {

    @tailrec
    def compute(number: Long, divider: Int, result: List[Int]): List[Int] = {
      if (number == 1) result
      else if (number % divider > 0) compute(number, divider + 1, result)
      else compute(number / divider, divider, result :+ divider)
    }
    compute(number, 2, List())
  }
}
