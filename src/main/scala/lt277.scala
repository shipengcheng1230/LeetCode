object lt277 {

  def knows(a: Int, b: Int): Boolean = {???}

  def findCelebrity(n: Int): Int = {
    var candidate = 0
    for (i <- 0 until n) {
      if (knows(candidate, i))
        candidate = i
    }
    for (j <- 0 until n; if j != candidate) {
      if (knows(candidate, j) || !knows(j, candidate))
        return -1
    }
    candidate
  }
}
