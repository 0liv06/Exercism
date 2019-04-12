object Bob {

  def isMatching(statement: String, pattern: String): Boolean = pattern.r.pattern.matcher(statement.trim).matches()
  def isShouting(statement: String): Boolean = isMatching(statement, "[^a-z]+[A-Z]+.+")
  def isAskingQuestion(statement: String): Boolean = isMatching(statement, ".+\\?")

  def response(statement: String): String = {
    if (statement.trim.isEmpty) "Fine. Be that way!"
    else if (isShouting(statement) && isAskingQuestion(statement)) "Calm down, I know what I'm doing!"
    else if (isShouting(statement)) "Whoa, chill out!"
    else if (isAskingQuestion(statement)) "Sure."
    else "Whatever."
  }
}
