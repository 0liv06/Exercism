object Series {
  def slices(slice: Int, series: String): List[List[Int]] = (0 until series.length).sliding(slice).map(_.toList).toList
}
