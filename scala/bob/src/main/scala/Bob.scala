object Bob {

  def isMatching(statement: String, pattern: String): Boolean = pattern.r.pattern.matcher(statement.trim).matches()
  def isShouting(statement: String): Boolean = isMatching(statement, "[^a-z]+[A-Z]+.+")
  def isAskingQuestion(statement: String): Boolean = isMatching(statement, ".+\\?")

  def response(statement: String): String = {
    (statement.trim.isEmpty, isShouting(statement), isAskingQuestion(statement)) match {
      case (true, _, _) => "Fine. Be that way!"
      case (_, true, true) => "Calm down, I know what I'm doing!"
      case (_, true, false) => "Whoa, chill out!"
      case (_, false, true) => "Sure."
      case _ => "Whatever."
    }
  }
}
