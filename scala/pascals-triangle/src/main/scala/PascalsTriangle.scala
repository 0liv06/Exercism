import scala.annotation.tailrec

object PascalsTriangle {

  def rows(numRow: Int): List[List[Int]] = {

    @tailrec
    def computeTriangle(row: Int, triangle:List[Int], result: List[List[Int]]): List[List[Int]] = {
      if (row <= 0 ) result
      else {

        val computedTriangle = for {
          i <- triangle.indices
        } yield  if (i + 1 < triangle.length) triangle(i) + triangle(i + 1) else 1

        val newTriangleEntry = 1 +: computedTriangle.toList

        computeTriangle(row - 1, newTriangleEntry, result ++ List(newTriangleEntry))
      }
    }
    computeTriangle(numRow, List(), List())
  }
}
