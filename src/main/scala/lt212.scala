object lt212 {

  import scala.collection.mutable

  class TrieNode {
    var children: mutable.Map[Char, TrieNode] = mutable.Map.empty[Char, TrieNode]
    var endsWord: Option[String] = None
    def prune(c: Char): Unit = children -= c
  }

  class Trie {
    val root = new TrieNode()

    def add(word: String): Unit = {
      var curr = root
      word.foreach(c => {
        curr = curr.children.getOrElseUpdate(c, new TrieNode())
      })
      curr.endsWord = Some(word)
    }
  }

  object Solution {

    def buildTrie(words: Array[String]): Trie = {
      val trie = new Trie()
      words.foreach(trie.add)
      trie
    }

    def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
      var matches = Set.empty[String]
      val trie = buildTrie(words)
      val rows = board.length
      val cols = board.head.length

      def inBounds(xy: (Int, Int)): Boolean =
        xy._1 >= 0 && xy._1 < rows && xy._2 >= 0 && xy._2 < cols

      def getNeighbors(xy: (Int, Int)): List[(Int, Int)] =
        List(
          (xy._1 + 1, xy._2),
          (xy._1 - 1, xy._2),
          (xy._1, xy._2 + 1),
          (xy._1, xy._2 - 1),
        ).filter(inBounds)

      def checkMatches(node: TrieNode, xy: (Int, Int)): Unit = {
        val letter = board(xy._1)(xy._2)
        if (node.children.contains(letter)) {
          val matched = node.children(letter)
          if (matched.endsWord.nonEmpty) matches += matched.endsWord.get
          board(xy._1)(xy._2) = '#'
          getNeighbors(xy).foreach(checkMatches(matched, _))
          board(xy._1)(xy._2) = letter
          if (matched.children.isEmpty) node.prune(letter)
        }
      }

      for (i <- 0 until rows; j <- 0 until cols)
        checkMatches(trie.root, (i, j))

      matches.toList
    }
  }

}
