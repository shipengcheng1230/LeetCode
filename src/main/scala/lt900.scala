// https://leetcode.com/problems/rle-iterator/submissions/
object lt900 {
  class RLEIterator(_A: Array[Int]) {

    var i = 0
    var q = 0

    def next(n: Int): Int = {
      var remain = n
      while (i < _A.length) {
        if (q + remain > _A(i)) {
          remain -= _A(i) - q
          q = 0
          i += 2
        } else {
          q += remain
          return _A(i + 1)
        }
      }
      -1
    }

  }
}
