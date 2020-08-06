object lt763 {
  def partitionLabels(S: String): List[Int] = {
    val intervals = S.zipWithIndex.foldLeft(Map.empty[Char, (Int, Int)])((acc, x) => {
      acc.updated(x._1, (acc.get(x._1).map(_._1).getOrElse(x._2), x._2))
    })
    intervals.values.toSeq.sorted.foldLeft(List.empty[(Int, Int)]) {
      case (Nil, (start, end)) => List((start, end))
      case (acc @ (s1, e1) :: rest, interval @ (s2, e2)) =>
        if (s2 <= e1) (s1, e1 max e2) :: rest
        else interval :: acc
    }.reverse.map(x => x._2 - x._1 + 1)
  }
}
