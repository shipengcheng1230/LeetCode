// https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
object lt1564 {
  def maxBoxesInWarehouse(boxes: Array[Int], warehouse: Array[Int]): Int = {
    boxes.sortInPlace()
    val m = boxes.length
    val n = warehouse.length
    var res = 0
    for (i <- 0 until m if res < n) {
      if (boxes(m - i - 1) <= warehouse(res))
        res += 1
    }
    res
  }
}
