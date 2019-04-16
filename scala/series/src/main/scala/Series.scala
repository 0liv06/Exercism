object Series {
  def slices(slice: Int, series: String): List[List[Int]] = (0 to series.length - slice).map(i => series.slice(i, i + slice).map(c => c.asDigit).toList).toList
}
