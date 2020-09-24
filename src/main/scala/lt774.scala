// https://leetcode.com/problems/minimize-max-distance-to-gas-station/
object lt774 {
  def minmaxGasDist(stations: Array[Int], K: Int): Double = {

    val diff = Array.ofDim[Int](stations.length - 1)
    diff.indices.foreach(i => diff(i) = stations(i + 1) - stations(i))

    def possible(x: Double): Boolean = {
      var used = 0
      diff.foreach(d => {
        used += math.floor(d / x).toInt
      })
      used <= K
    }

    var lo = 0.0
    var hi = 1e8
    while (hi - lo > 1e-6) {
      val mi = (lo + hi) / 2.0
      if (possible(mi)) hi = mi
      else lo = mi
    }
    hi
  }
}
