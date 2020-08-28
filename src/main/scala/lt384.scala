// https://leetcode.com/problems/shuffle-an-array/
object lt384 {
  class Solution(_nums: Array[Int]) {

    import util.Random

    val rand = new Random
    var array: Array[Int] = _nums
    var original: Array[Int] = _nums.clone()

    def swap(i: Int, j: Int): Unit = {
      val tmp = array(i)
      array(i) = array(j)
      array(j) = tmp
    }

    /** Resets the array to its original configuration and return it. */
    def reset(): Array[Int] = {
      array = original
      original = original.clone()
      original
    }

    /** Returns a random shuffling of the array. */
    def shuffle(): Array[Int] = {
      array.indices.foreach(i => swap(i, rand.between(i, array.length)))
      array
    }

  }
}
