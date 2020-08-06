object lt819 {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    paragraph
      .toLowerCase
      .map(c => if ("!?',;.".contains(c)) ' ' else c)
      .split(" ")
      .map(_.trim)
      .groupBy(identity)
      .view.filterKeys(!banned.contains(_))
      .mapValues(_.length)
      .maxBy(_._2)._1
  }
}
