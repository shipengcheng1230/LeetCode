object lt733 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val nrow = image.length
    val ncol = image.head.length
    val color = image(sr)(sc)
    if (color == newColor) return image
    val image2 = image.map(_.clone)

    def dfs(r: Int, c: Int): Unit = {
      if (image2(r)(c) == color) {
        image2(r)(c) = newColor
        if (r >= 1) dfs(r-1, c)
        if (r < nrow-1) dfs(r+1, c)
        if (c >= 1) dfs(r, c-1)
        if (c < ncol-1) dfs(r, c+1)
      }
    }
    dfs(sr, sc)
    image2
  }
}