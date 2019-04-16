object Anagram {

  private lazy val wordsNotEquals: (String, String) => Boolean = (w: String, w2:String) => !w.toLowerCase.equals(w2.toLowerCase)
  private lazy val equalLength: (String, String) => Boolean = (w: String, w2:String) => w.length == w2.length
  private lazy val sameLetters: (String, String) => Boolean = (w: String, w2: String) => w.toLowerCase.sorted.equals(w2.toLowerCase.sorted)

  def findAnagrams(word: String, candidate: List[String]): List[String] = {
    candidate.filter(f => wordsNotEquals(f, word) && equalLength(f, word) && sameLetters(f, word))
  }
}
