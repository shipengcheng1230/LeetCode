import scala.collection.mutable

object lt642 {

  import scala.collection.mutable

  class TrieNode {
    val children = mutable.Map.empty[Char, TrieNode]
    var isEnd = false
    var data = ""
    var rank = 0
  }

  class AutocompleteSystem(_sentences: Array[String], _times: Array[Int]) {

    val root = new TrieNode
    var keyword = ""
    (_sentences zip _times).foreach(x => addRecord(x._1, x._2))

    def addRecord(str: String, i: Int): Unit = {
      val p = str.foldLeft(root)((acc, x) => acc.children.getOrElseUpdate(x, new TrieNode))
      p.isEnd = true
      p.data = str
      p.rank -= i
    }

    def dfs(node: TrieNode): mutable.ListBuffer[(Int, String)] = {
      val ret = mutable.ListBuffer.empty[(Int, String)]
      if (node.isEnd) ret.append((node.rank, node.data))
      node.children.foreach(x => ret.appendAll(dfs(x._2)))
      ret
    }

    def search(sentence: String): mutable.ListBuffer[(Int, String)] = {
      val p = sentence.foldLeft(root)((acc, x) => {
        if (acc.children.contains(x)) acc.children(x)
        else return mutable.ListBuffer.empty[(Int, String)]
      })
      dfs(p)
    }

    def input(c: Char): List[String] = {
      if (c != '#') {
        keyword += c
        search(keyword).sorted.map(_._2).take(3).toList
      } else {
        addRecord(keyword, 1)
        keyword = ""
        List.empty[String]
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val a = new AutocompleteSystem(Array("abc", "abbc", "a"), Array(3, 3, 3))
    val inputs = List("b","c","#","b","c","#","a","b","c","#","a","b","c","#").flatMap(_.toList)
    inputs.foreach(x => println(a.input(x)))
  }
}
