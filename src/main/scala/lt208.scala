// https://leetcode.com/problems/implement-trie-prefix-tree/
object lt208 {
  class Trie() {
    import scala.collection.mutable.Map

    /** Initialize your data structure here. */
    class TrieNode {
      var word: String = _
      var children = Map.empty[Char, TrieNode]
    }

    val root = new TrieNode

    /** Inserts a word into the trie. */
    def insert(word: String) {
      var curr = root
      word.foreach(c => {
        if (!curr.children.contains(c)) curr.children.update(c, new TrieNode)
        curr = curr.children(c)
      })
      curr.word = word
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
      var curr = root
      word.foreach(c => {
        if (!curr.children.contains(c)) return false
        curr = curr.children(c)
      })
      curr.word == word
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
      var curr = root
      prefix.foreach(c => {
        if (!curr.children.contains(c)) return false
        curr = curr.children(c)
      })
      true
    }
  }
}
