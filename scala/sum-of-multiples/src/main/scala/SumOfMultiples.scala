object SumOfMultiples {

  def isMultiple(a: Int, b: Int): Int = {
    if (a % b == 0) a
    else 0
  }

  def getFactors(factors:Set[Int], limit: Int) = for {
    a <- 0 until limit
    b <- factors
  } yield isMultiple(a, b)

  def sum(factors: Set[Int], limit: Int): Int = getFactors(factors, limit).sum
}
