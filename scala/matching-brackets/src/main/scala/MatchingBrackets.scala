import scala.annotation.tailrec

object MatchingBrackets {

  val matches = Map('{' -> '}', '[' -> ']', '(' -> ')')

  def isPaired(s: String): Boolean = {

    @tailrec
    def hasPair(candidate: String, index: Int, result: Boolean): Boolean = {
      if (!result || index == 0) result
      else if (matches.get(candidate.head).equals(candidate.tail.headOption)) hasPair(candidate.tail.tail, index -1, matches.get(candidate.head).equals(candidate.tail.headOption))
      else hasPair(candidate.tail.dropRight(1), index - 1, matches.get(candidate.head).equals(Option(candidate(candidate.length -1))))
    }

    val filtered = s.toLowerCase.replaceAll("[^\\[\\]\\{\\}\\(\\)]", "")
    hasPair(filtered, Math.round(filtered.length.toFloat / 2), true)
  }
}
