// https://leetcode.com/problems/find-duplicate-file-in-system/
object lt609 {
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val regex = "(.+)\\((.+)\\)".r

    paths.toList.flatMap(_.split(' ').toSeq match {
      case d +: fs => fs.map {
        case regex(path, content) => content -> (d + '/' + path)
      }
    })
      .groupBy(_._1)
      .values
      .filter(_.size > 1)
      .map(_.map(_._2)).toList
  }
}
