// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
object lt1423 {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    val n = cardPoints.length - k
    var init = cardPoints.slice(0, n).sum
    var ans = init
    (1 to k).foreach(i => {
      init = init - cardPoints(i - 1) + cardPoints(i + n - 1)
      ans = ans min init
    })
    cardPoints.sum - ans
  }

  def main(args: Array[String]): Unit = {
    print(maxScore(Array(1,2,3,4,5,6,1), 3))
  }
}
