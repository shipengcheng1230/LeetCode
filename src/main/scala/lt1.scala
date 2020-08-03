import scala.annotation.tailrec
import scala.collection.immutable.HashMap

object lt1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    @tailrec
    def helper(map: HashMap[Int, Int], i: Int): Array[Int] = {
      val complement = target - nums(i)
      if (map contains complement) Array(map(complement), i)
      else helper(map.updated(nums(i), i), i+1)
    }

    helper(new HashMap[Int, Int](), 0)
  }
}
