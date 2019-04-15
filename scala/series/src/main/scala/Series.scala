object Series {

  def slices(slice: Int, series: String): List[List[Int]] = {
    if (series.isEmpty) List()
    else {
      val slices = for {
        s <- 0 until series.length - (slice - 1)
      } yield series.substring(s, s + slice).toList.map(f => f.asDigit)
      slices.toList
    }
  }
}
