object MatchingBrackets {

  val matches = Map('{' -> '}', '[' -> ']', '(' -> ')')

  def isPaired(s: String): Boolean = {

    def hasPair(candidate: String, index: Int, result: Boolean): Boolean = {
      if (!result || index == 0) result
      else {
        val a = matches.get(candidate.head)
        val b = Option(candidate(candidate.length -1))
        hasPair(candidate.tail.dropRight(1), index - 1, a.equals(b))
      }
    }

    val filtered = s.toLowerCase.replaceAll("[^\\[\\]\\{\\}\\(\\)]", "")
    hasPair(filtered, filtered.length / 2, true)
  }
}
