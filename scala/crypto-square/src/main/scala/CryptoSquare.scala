object CryptoSquare {
  private def normalize(message: String): String = message.toLowerCase.replaceAll("[^a-z1-9]", "")

  private def numberCols(message: String): Int = (1 until message.length).filter(n => n >= message.length / n)(0)

  def ciphertext(message: String): String = {
    if (message.isEmpty) ""
    else {
      val cols = numberCols(message)
      val chunks: List[String] = normalize(message).sliding(cols, cols).toList
      val encodedMessage = for {
        index <- 0 until cols
        chunkIndex <- chunks.indices
      } yield if (index < chunks(chunkIndex).length) chunks(chunkIndex)(index) else ""

      encodedMessage.sliding(cols - 1, cols - 1).map(f => f.mkString).mkString(" ").trim
    }
  }
}
