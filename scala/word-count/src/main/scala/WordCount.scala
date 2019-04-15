case class WordCount(word: String) {

  lazy private val wordCount: Array[String] = word.toLowerCase.split("([^A-Za-z0-9'])").map(w => w.trim.stripPrefix("'").stripSuffix("'")).filter(!_.trim.equals(""))

  def countWords(): Map[String, Int] =  {
    wordCount.map(s => s -> wordCount.count(_.equals(s))).toMap
  }
}
