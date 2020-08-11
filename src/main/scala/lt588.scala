object lt588 {

  import scala.collection.mutable

  class Node {
    val child = mutable.Map.empty[String, Node]
    var content = ""
  }

  class FileSystem() {

    val root = new Node

    def find(path: String): Node = {
      if (path.length == 1) root
      else {
        var curr = root
        path.split("/").tail.foreach(word => curr = curr.child.getOrElseUpdate(word, new Node))
        curr
      }
    }

    def ls(path: String): List[String] = {
      val curr = find(path)
      if (curr.content.nonEmpty) List(path.split("/").last)
      else curr.child.keys.toList.sorted
    }

    def mkdir(path: String): Unit = {
      find(path)
    }

    def addContentToFile(filePath: String, content: String): Unit = {
      val curr = find(filePath)
      curr.content += content
    }

    def readContentFromFile(filePath: String): String = {
      val curr = find(filePath)
      curr.content
    }

  }

  def main(args: Array[String]): Unit = {
    val f = new FileSystem
    print(f.ls("/"))
    f.mkdir("/a/b/c")
    f.addContentToFile("/a/b/c/d", "hello")
    print(f.ls("/"))
    print(f.readContentFromFile("/a/b/c/d"))
  }
}
