object CryptoSquare {

  private def normalize(message: String): String = message.toLowerCase.replaceAll("[^a-z1-9]", "")

  private def numberCols(msgLength: Int, colsIdx: Int): Int = {
    if (colsIdx >= msgLength / colsIdx) colsIdx
    else numberCols(msgLength, colsIdx + 1)
  }

  def ciphertext(message: String): String = {
    if (message.isEmpty) ""
    else {
      val normalizedString = normalize(message)
      val slideIndex = numberCols(normalizedString.length, 1)
      val numCols = if (slideIndex % normalizedString.length > 5) slideIndex + 1 else slideIndex
      val chunks: List[String] = normalizedString.sliding(numCols, numCols).toList
      val encodedMessage = for {
        index <- 0 until chunks.head.length
        chunkIndex <- chunks.indices
      } yield {
        if (index < chunks(chunkIndex).length ) chunks(chunkIndex)(index)
        else " "
      }
      encodedMessage.sliding(slideIndex, slideIndex).map(f => f.mkString).mkString(" ")
    }
  }
}
