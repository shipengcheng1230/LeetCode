object lt937 {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    val (dig, let) = logs.partition(_.split(' ').tail.head.head.isDigit)
    let.sortBy(_.span(_ != ' ').swap) ++ dig
  }
}
