object lt679 {
  def judgePoint24(nums: Array[Int]): Boolean = {
    def judge24(nums: List[Float]): Boolean = nums match {
      case Nil => false
      case a :: Nil => Math.abs(a - 24) < 1e-3
      case a :: b :: xs => List(a+b, a-b, a*b, a/b).map(_ :: xs).flatMap(_.permutations).exists(judge24)
    }

    nums.map(_.toFloat).toList.permutations.exists(judge24)
  }
}
