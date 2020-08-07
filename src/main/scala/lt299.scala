object lt299 {
  def getHint(secret: String, guess: String): String = {

    val h = scala.collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var bull = 0
    var cow = 0
    (secret zip guess).foreach(c => {
      if (c._1 == c._2) bull += 1
      else {
        cow += (if (h(c._1) < 0) 1 else 0) +  (if (h(c._2) > 0) 1 else 0)
        h(c._1) += 1
        h(c._2) -= 1
      }
    })
    s"${bull}A${cow}B"
  }
}
