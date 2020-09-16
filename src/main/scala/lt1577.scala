// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
object lt1577 {
  def numTriplets(nums1: Array[Int], nums2: Array[Int]): Int = {
    val n1s = nums1.groupMapReduce(x => x * x.toLong)(_ => 1)(_ + _)
    val n2s = nums2.groupMapReduce(x => x * x.toLong)(_ => 1)(_ + _)
    var ans = 0
    for (i <- 0 until nums2.length - 1;
         j <- i + 1 until nums2.length;
         product = nums2(i) * nums2(j).toLong
         if (n1s.contains(product))) ans += n1s(product)

    for (i <- 0 until nums1.length - 1;
         j <- i + 1 until nums1.length;
         product = nums1(i) * nums1(j).toLong
         if (n2s.contains(product))) ans += n2s(product)

    ans
  }
}
