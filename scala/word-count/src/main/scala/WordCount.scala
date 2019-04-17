case class WordCount(word: String) {

  lazy private val words: Array[String] = word.toLowerCase.split("([^A-Za-z0-9'])").map(w => w.trim.stripPrefix("'").stripSuffix("'")).filter(!_.trim.equals(""))
  lazy private val wordCount: Map[String, Int] = words.groupBy(_.toString).mapValues(_.length)

  def countWords(): Map[String, Int] = wordCount

}
