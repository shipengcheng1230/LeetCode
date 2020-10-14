// https://leetcode.com/problems/alphabet-board-path/
object lt1138 {
  def alphabetBoardPath(target: String): String = {
    import scala.collection.mutable.Map

    val board = Array("abcde", "fghij", "klmno", "pqrst", "uvwxy", "z")

    val table = Map.empty[Char, (Int, Int)]
    board.zipWithIndex.foreach { case (s, i) =>
      s.zipWithIndex.foreach { case (c, j) =>
        table.update(c, (i, j))
      }
    }

    println(table.toList)
    val ans = new StringBuilder
    var curr = (0, 0)
    target.foreach { c =>
      val dest = table(c)
      val dx = dest._1 - curr._1
      val dy = dest._2 - curr._2
      if (c == 'z') ans.append("L" * -dy).append("D" * dx)
      else {
        if (dx > 0) ans.append("D" * dx) else ans.append("U" * -dx)
        if (dy > 0) ans.append("R" * dy) else ans.append("L" * -dy)
      }
      ans.append("!")
      curr = dest
    }
    ans.toString
  }
}
