// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/
object lt1611 {
  def minimumOneBitOperations(x: Int): Int = {
    var n = x
    n ^= n >> 16;
    n ^= n >>  8;
    n ^= n >>  4;
    n ^= n >>  2;
    n ^= n >>  1;
    return n;
  }
}
