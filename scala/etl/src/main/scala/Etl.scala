object Etl {

  def transform(values: Map[Int, Seq[String]]): Map[String, Int] = {
    values.flatMap(f => f._2.map(_.toLowerCase -> f._1))
  }
}
