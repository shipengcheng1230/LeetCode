// https://leetcode.com/problems/minimum-window-substring/
object lt76 {
  def minWindow(s: String, t: String): String = {
    if (s.isEmpty || t.isEmpty) "" else {
      import scala.collection.mutable

      val tdict = mutable.Map.empty[Char, Int]
      t.foreach(x => tdict.update(x, tdict.getOrElse(x, 0) + 1))
      val required = tdict.size

      var (l, r) = (0, 0)
      val wdict = mutable.Map.empty[Char, Int]
      var formed = 0
      val ans = Array(-1, 0, 0)

      while (r < s.length) {
        val c = s(r)
        wdict.update(c, wdict.getOrElse(c, 0) + 1)
        if (tdict.contains(c) && tdict(c) == wdict(c)) formed += 1

        while (l <= r && formed == required) {
          val c2 = s(l)
          if (ans(0) == -1 || r - l + 1 < ans(0)) {
            ans(0) = r - l + 1
            ans(1) = l
            ans(2) = r
          }
          wdict.update(c2, wdict(c2) - 1)
          if (tdict.contains(c2) && tdict(c2) > wdict(c2)) formed -= 1
          l += 1
        }
        r += 1
      }
      if (ans(0) == -1) "" else s.substring(ans(1), ans(2) + 1)
    }
  }
}
