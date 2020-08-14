object lt265 {
  def minCostII(costs: Array[Array[Int]]): Int = {
    if (costs.isEmpty || costs.head.isEmpty) return 0
    val n = costs.length
    val k = costs.head.length

    (1 until n).foreach(house => {
      var minColor = -1
      var secondMinColor = -1
      (0 until k).foreach(color => {
        val cost = costs(house-1)(color)
        if (minColor == -1 || cost < costs(house-1)(minColor)) {
          secondMinColor = minColor
          minColor = color
        } else if (secondMinColor == -1 || cost < costs(house-1)(secondMinColor)) {
          secondMinColor = color
        }
      })
      (0 until k).foreach(color => {
        if (color == minColor) costs(house)(color) += costs(house-1)(secondMinColor)
        else costs(house)(color) += costs(house-1)(minColor)
      })
    })
    costs(n-1).min
  }
}
