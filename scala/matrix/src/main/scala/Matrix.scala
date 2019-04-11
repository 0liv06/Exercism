case class Matrix(matrix: String) {


  def row(idx: Int): Vector[Int] = matrix.split("\n")(idx).split(" ").map(_.toInt).toVector
  def column(idx: Int): Vector[Int] = {
    val mat = matrix.split("\n").map(f => f.split(" ").map(_.toInt))
    val seq = mat.indices
    seq.map(f => mat(f)(idx)).toVector
  }
}