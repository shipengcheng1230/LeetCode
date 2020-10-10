object lt211 {
  class WordDictionary() {
    import scala.collection.mutable.Map

    class TrieNode {
      var word: String = _
      val children = Map.empty[Char, TrieNode]
    }

    /** Initialize your data structure here. */
    val root = new TrieNode

    /** Adds a word into the data structure. */
    def addWord(word: String) {
      var curr = root
      word.foreach(c => {
        if (!curr.children.contains(c)) curr.children.update(c, new TrieNode)
        curr = curr.children(c)
      })
      curr.word = word
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    def search(word: String): Boolean = {

      def helper(ws: String, node: TrieNode): Boolean = {
        if (ws.isEmpty) {
          node.word != null
        }
        else if (ws.head == '.') node.children.exists { case (k, v) =>
          helper(ws.tail, v)
        } else {
          if (!node.children.contains(ws.head)) {
            false
          }
          else helper(ws.tail, node.children(ws.head))
        }
      }

      helper(word, root)
    }
  }
}
