// https://leetcode.com/problems/palindrome-pairs/
object lt336 {

  import scala.collection.mutable

  class TrieNode {
    var wordEnding: Int = -1
    val next = mutable.Map.empty[Char, TrieNode]
    val palindromePrefixRemaining = mutable.ListBuffer.empty[Int]
  }

  def hasPalindromeRemaining(s: String, i: Int): Boolean = {
    var p1 = i
    var p2 = s.length - 1
    while (p1 < p2) {
      if (s(p1) != s(p2)) return false
      p1 += 1
      p2 -= 1
    }
    true
  }

  def palindromePairs(words: Array[String]): List[List[Int]] = {
    // build Trie
    val trie = new TrieNode
    words.indices.foreach(i => {
      val word = words(i)
      val reversedWord = word.reverse
      var curr = trie
      word.indices.foreach(j => {
        if (hasPalindromeRemaining(reversedWord, j))
          curr.palindromePrefixRemaining.append(i)

        val c = reversedWord(j)
        if (!curr.next.contains((c)))
          curr.next.update(c, new TrieNode)

        curr = curr.next(c)
      })
      curr.wordEnding = i
    })

    // find pairs
    val pairs = mutable.ListBuffer.empty[List[Int]]
    words.indices.foreach(i => {
      val word = words(i)
      var curr = trie
      for {j <- 0 until word.length if curr != null} {
        if (curr.wordEnding != -1 && hasPalindromeRemaining(word, j))
          pairs.addOne(List(i, curr.wordEnding))

        curr = curr.next.getOrElse(word(j), null)
      }

      if (curr != null) {
        if (curr.wordEnding != -1 && curr.wordEnding != i)
          pairs.addOne(List(i, curr.wordEnding))

        curr.palindromePrefixRemaining.foreach(other => pairs.addOne(List(i, other)))
      }
    })
    pairs.toList
  }
}
