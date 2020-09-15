// https://leetcode.com/problems/number-of-ships-in-a-rectangle/
object lt1274 {

  class Sea {
    def hasShips(topRight: Array[Int], bottomLeft: Array[Int]): Boolean = ???
  }

  def countShips(sea: Sea, topRight: Array[Int], bottomLeft: Array[Int]): Int = {

    if (!sea.hasShips(topRight, bottomLeft)) 0
    else if (topRight(0) == bottomLeft(0) && topRight(1) == bottomLeft(1)) 1
    else {
      val mx = (topRight(0) + bottomLeft(0)) / 2
      val my = (topRight(1) + bottomLeft(1)) / 2
      countShips(sea, Array(mx, my), bottomLeft) +
        countShips(sea, topRight, Array(mx + 1, my + 1)) +
        countShips(sea, Array(mx, topRight(1)), Array(bottomLeft(0), my + 1)) +
        countShips(sea, Array(topRight(0), my), Array(mx + 1, bottomLeft(1)))
    }
  }
}
