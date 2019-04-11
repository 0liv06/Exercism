object Bob {

  def isMatching(statement: String, pattern: String): Boolean = pattern.r.pattern.matcher(statement).matches()

  def isShouting(statement: String): Boolean = isMatching(statement, "[^a-z]+[A-Z]+.+")

  def response(statement: String): String = {

    if (isShouting(statement)) "Whoa, chill out!"
    else "Whatever."

  }
}
