object Pangrams {
  def isPangram(input: String): Boolean = input.toLowerCase.filter(_.isLetter).distinct.length >= 26
}

