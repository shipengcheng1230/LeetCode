// https://leetcode.com/problems/subsets/
object lt78 {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    import scala.annotation.tailrec

    @tailrec
    def helper(nums: List[Int], ans: List[List[Int]]): List[List[Int]] = nums match {
      case Nil => ans
      case x :: xs => helper(xs, ans.map(x :: _) ::: ans)
    }

    helper(nums.toList, List(List()))
  }

  def main(args: Array[String]): Unit = {
    println(subsets(Array(1,2,3)))
  }
}
