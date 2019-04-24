import scala.annotation.tailrec

object Series {

  private def sliding(s: String, size: Int): Option[Iterator[String]] = {
    if (size > 0) Some(s.sliding(size))
    else Some(List("1").iterator)
  }

  @tailrec
  private def doProduct(s: String, i: Int, res: Int): Int = {
    if (i == 0) res
    else doProduct(s.tail, i - 1, res * s.head.asDigit)
  }

  def largestProduct(x: Int, product: String): Option[Int] = {
    if (x >=0 && x <= product.length && product.matches("[0-9]+|^$") ) {
      val chunks = sliding(product, x).map(f => f.map(s => doProduct(s, x, 1)))
      chunks.map(f => f.max)
    } else None
  }
}
