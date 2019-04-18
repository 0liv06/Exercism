object CryptoSquare {

  private def normalize(message: String): String = message.toLowerCase.replaceAll("[^a-z1-9]", "")

  private def numberCols(msgLength: Int): Int = {
    Math.sqrt(msgLength).toInt
  }

  def ciphertext(message: String): String = {
    if (message.isEmpty) ""
    else {
      val normalizedMessage = normalize(message)
      val numRows = numberCols(normalizedMessage.length)
      val numCols = if ((numRows * numRows) % normalizedMessage.length > 0) numRows + 1 else numRows
      val chunks: List[String] = normalizedMessage.sliding(numCols, numCols).toList.map(f => f.padTo(numCols, " ").mkString)
      val encodedMessage = (0 until numCols).map(idx => chunks.map(_(idx))).toList

      encodedMessage.map(_.mkString).mkString(" ")
    }
  }
}
