object Series {
  def slices(slice: Int, series: String): List[List[Int]] = (0 to series.length - slice).map(s => series.substring(s, s + slice).toList.map(_.asDigit)).toList
}
