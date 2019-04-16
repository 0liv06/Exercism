case class WordCount(word: String) {

  lazy private val words: Array[String] = word.toLowerCase.split("([^A-Za-z0-9'])").map(w => w.trim.stripPrefix("'").stripSuffix("'")).filter(!_.trim.equals(""))

  def countWords(): Map[String, Int] =  {
    words.map(s => s -> words.count(_.equals(s))).toMap
  }
}
