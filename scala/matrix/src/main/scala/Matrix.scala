case class Matrix(baseMatrix: String) {

  val rows: Vector[Vector[Int]] =  baseMatrix.split("\n").map(f => f.split(" ").map(_.toInt).toVector).toVector
  val cols: Vector[Vector[Int]] = rows(0).indices.map(idx  => rows.map(_(idx))).toVector

  def row(idx: Int): Vector[Int] = rows(idx)
  def column(idx: Int): Vector[Int] = cols(idx)

}