object lt1608 {
  def specialArray(nums: Array[Int]): Int = {
    val count = Array.fill(1001)(0)
    nums.foreach(num => count(num) += 1)
    var accu = 0
    for (i <- count.length - 1 to 0 by -1) {
      accu += count(i)
      if (accu == i) return i
    }
    -1
  }
}
