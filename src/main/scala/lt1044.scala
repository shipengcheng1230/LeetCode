// https://leetcode.com/problems/longest-duplicate-substring/
object lt1044 {
  def longestDupSubstring(S: String): String = {

    val n = S.length
    val nums = S.map(_ - 'a').toArray
    val a = 26
    val modulus = math.pow(2.toDouble, 32).toLong
    var left = 1
    var right = n
    while (left <= right) {
      val L = left + (right - left) / 2
      if (search(L, a, modulus, n, nums) != -1) left = L + 1
      else right = L - 1
    }
    val start = search(left - 1, a, modulus, n, nums)
    S.substring(start, start + left - 1)
  }

  def search(L: Int, a: Int, modulus: Long, n: Int, num: Array[Int]): Int = {
    var h = num.slice(0, L).foldLeft(0.toLong)((acc, x) => (acc * a + x) % modulus)
    val seen = scala.collection.mutable.Set.empty[Long]
    seen.addOne(h)
    val aL = (1 to L).foldLeft(1.toLong)((acc, _) => (acc * a) % modulus)

    (1 until n - L + 1).foreach(start => {
      h = (h * a - num(start - 1) * aL % modulus + modulus) % modulus
      h = (h + num(start + L - 1)) % modulus
      if (seen.contains(h)) return start
      seen.addOne(h)
    })
    -1
  }
}
