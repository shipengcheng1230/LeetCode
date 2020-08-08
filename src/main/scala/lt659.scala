object lt659 {
  def isPossible(nums: Array[Int]): Boolean = {
    if (nums.isEmpty || nums.length <= 0) return false

    var pre = Integer.MIN_VALUE
    var cur = 0
    var p1 = 0
    var p2 = 0
    var p3 = 0
    var c1 = 0
    var c2 = 0
    var c3 = 0

    var i = 0
    while (i < nums.length) {
      cur = nums(i)
      var cnt = 0
      while (i < nums.length && cur == nums(i)) {
        i += 1
        cnt += 1
      }
      if (pre + 1 != cur) {
        if (p1 != 0 || p2 != 0) return false
        c1 = cnt
        c2 = 0
        c3 = 0
      } else {
        if (cnt < p1 + p2) return false
        c2 = p1
        c3 = p2
        var residual = cnt - p1 - p2
        var numExtend = Math.min(p3, residual)
        c3 += numExtend
        c1 = Math.max(0, residual - numExtend)
      }
      pre = cur
      p1 = c1
      p2 = c2
      p3 = c3
    }
    p1 == 0 && p2 == 0
  }
}
