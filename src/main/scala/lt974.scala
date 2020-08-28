// https://leetcode.com/problems/subarray-sums-divisible-by-k/
object lt974 {
  def subarraysDivByK(A: Array[Int], K: Int): Int = {
    A.scanLeft(0)(_ + _).map(x => (x % K + K) % K)
      .groupMapReduce(identity)(_ => 1)(_ + _).values
      .map(x => x * (x - 1) / 2).sum
  }

  def main(args: Array[String]): Unit = {
    println(subarraysDivByK(Array(-1,2,9), 2))
  }
}
