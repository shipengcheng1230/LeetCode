// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
object lt1130 {
  def mctFromLeafValues(arr: Array[Int]): Int = {
    var a = arr.clone()
    var sum = 0
    while (a.length > 1) {
      val (_, ind) = a.zipWithIndex.minBy(_._1)
      if (ind - 1 < 0)
        sum += a(ind) * a(ind + 1)
      else if (ind + 1 >= a.length)
        sum += a(ind - 1) * a(ind)
      else {
        if (a(ind - 1) < a(ind + 1))
          sum += a(ind - 1) * a(ind)
        else
          sum += a(ind) * a(ind + 1)
      }
      a = a.slice(0, ind) ++ a.slice(ind + 1, a.length)
    }
    sum
  }
}
