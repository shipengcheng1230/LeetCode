// https://leetcode.com/problems/permutations-ii/
object lt47 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    permute(nums.toList)
  }

  def permute(nums: List[Int]): List[List[Int]] = {
    nums match {
      case Nil => List(List.empty[Int])
      case _ => for {
        x <- nums.distinct
        perm <- permute(removeElem(nums, x))
      } yield x :: perm
    }
  }

  def removeElem(nums: List[Int], target: Int): List[Int] = nums match {
    case Nil => Nil
    case x :: xs => if (x == target) xs else x :: removeElem(xs, target)
  }

  def main(args: Array[String]): Unit = {
    println(permuteUnique(Array(1,1)))
  }
}
