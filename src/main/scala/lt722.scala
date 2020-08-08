object lt722 {
  def removeComments(source: Array[String]): List[String] = {
    import util.control.Breaks._

    var inBlock = false
    var newline = new StringBuilder
    val ans = scala.collection.mutable.ListBuffer.empty[String]

    source.foreach(line => {
      var i = 0
      if (!inBlock) newline = new StringBuilder
      breakable {
        while (i < line.length) {
          if (!inBlock && line.slice(i,i+2) == "/*") {
            inBlock = true
            i += 1
          } else if (inBlock && line.slice(i,i+2) == "*/") {
            inBlock = false
            i += 1
          } else if (!inBlock && line.slice(i,i+2) == "//") {
            break
          } else if (!inBlock) {
            newline.append(line(i))
          }
          i += 1
        }
      }
      if (!inBlock && newline.nonEmpty) ans.append(newline.toString)
    })
    ans.toList
  }
}