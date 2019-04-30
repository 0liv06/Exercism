object MatchingBrackets {

  val matches = Map('{' -> '}', '[' -> ']', '(' -> ')')

  def isPaired(s: String): Boolean = {

    def hasPair(candidate: String, index: Int, result: Boolean): Boolean = {
      if (!result || index == 0) result
      else {
        val a = matches.get(candidate.head)
        val b = Option(candidate(candidate.length -1))
        val c = candidate.tail.headOption

        if (a.equals(c)) hasPair(candidate.tail.tail, index -1, a.equals(c))
        else hasPair(candidate.tail.dropRight(1), index - 1, a.equals(b))
      }
    }

    val filtered = s.toLowerCase.replaceAll("[^\\[\\]\\{\\}\\(\\)]", "")
    hasPair(filtered, Math.round(filtered.length.toFloat / 2), true)
  }
}
