object Pangrams {
  def isPangram(input: String): Boolean = input.toLowerCase.replaceAll("[^a-zA-Z]", "").toCharArray.toSet.size >= 26
}

