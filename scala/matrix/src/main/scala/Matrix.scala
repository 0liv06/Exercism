class Matrix(val baseMatrix: String) {

  val matrix: Vector[Vector[Int]] =  baseMatrix.split("\n").map(f => f.split(" ").map(_.toInt).toVector).toVector

  def row(idx: Int): Vector[Int] = matrix(idx)
  def column(idx: Int): Vector[Int] = matrix.map(row => row(idx))

}

object Matrix {

  def apply(baseMatrix: String): Matrix = new Matrix(baseMatrix)
}