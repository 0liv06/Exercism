import scala.util.matching.Regex

object Bob {
  private val silence: Regex = "([\\s]*)".r
  private val shouting: Regex = "([^a-z]+[A-Z]+.+)".r
  private val question: Regex = "(.+\\?)\\s*".r
  private val forcefulQuestion: Regex = "([A-Z\\s]+[?])".r

  def response(statement: String): String = {
    statement match {
      case silence(_) => "Fine. Be that way!"
      case forcefulQuestion(_) => "Calm down, I know what I'm doing!"
      case shouting(_) => "Whoa, chill out!"
      case question(_) => "Sure."
      case _ => "Whatever."
    }
  }
}
