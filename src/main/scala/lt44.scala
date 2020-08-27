// https://leetcode.com/problems/wildcard-matching/
object lt44 {
  def isMatch(s: String, p: String): Boolean = {
    val sl = s.length
    val pl = p.length
    if (s == p || p == "*") return true
    if (p.isEmpty || s.isEmpty) return false

    val dp = Array.fill(pl + 1, sl + 1)(false)
    dp(0)(0) = true
    (1 to pl).foreach(pi => {
      if (p(pi - 1) == '*') {
        var si = 1
        while (!dp(pi - 1)(si - 1) && si <= sl) si += 1
        dp(pi)(si - 1) = dp(pi - 1)(si - 1)
        while (si <= sl) {
          dp(pi)(si) = true
          si += 1
        }
      } else if (p(pi - 1) == '?') {
        (1 to sl).foreach(si => dp(pi)(si) = dp(pi - 1)(si - 1))
      } else {
        (1 to sl).foreach(si => dp(pi)(si) = dp(pi - 1)(si - 1) && p(pi - 1) == s(si - 1))
      }
    })
    dp(pl)(sl)
  }

  def isMatch2(s: String, p: String): Boolean = {
    val sl = s.length
    val pl = p.length
    var si = 0
    var pi = 0
    var starIdx = -1
    var sTmpIdx = -1
    while (si < sl) {
      if (pi < pl && (p(pi) == '?' || p(pi) == s(si))) {
        si += 1
        pi += 1
      } else if (pi < pl && p(pi) == '*') {
        starIdx = pi
        sTmpIdx = si
        pi += 1
      } else if (starIdx == -1) {
        return false
      } else {
        pi = starIdx + 1
        si = sTmpIdx + 1
        sTmpIdx = si
      }
    }
    (pi until pl).foreach(i => if (p(i) != '*') return false)
    true
  }
}
