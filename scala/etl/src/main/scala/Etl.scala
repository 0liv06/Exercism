import scala.collection.immutable.TreeMap

object Etl {

  def transform(values: Map[Int, Seq[String]]): Map[String, Int] = {
    TreeMap(values.flatMap(f => f._2.map(_.toLowerCase -> f._1)).toSeq:_*)
  }
}
