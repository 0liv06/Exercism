object Bob {

  def isMatching(statement: String, pattern: String): Boolean = pattern.r.pattern.matcher(statement.trim).matches()

  def isShouting(statement: String): Boolean = isMatching(statement, "[^a-z]+[A-Z]+.+")
  def isAskingQuestion(statement: String) = isMatching(statement, ".+\\?")

  def response(statement: String): String = {

    if (isShouting(statement)) "Whoa, chill out!"
    else if (isAskingQuestion(statement)) "Sure."
    else "Whatever."

  }
}
