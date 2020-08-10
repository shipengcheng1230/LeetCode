// https://leetcode.com/problems/guess-the-word/
object lt843 {
  class Master {
    def guess(word: String): Int = {???}
  }

  def findSecretWord(wordlist: Array[String], master: Master): Unit = {
    var currentList = wordlist

    for (times <- 0 to 9) {
      // calculate frequency of each char among candidates
      val dict = (0 until 6).map(idx => currentList.map(_(idx)).groupMapReduce(identity)(_ => 1)(_ + _))

      // choose the candidate with highest char frequency
      val scores = currentList.map(word => (word, (0 until 6).map(id => dict(id)(word(id))).sum))
      val guess = scores.maxBy(_._2)._1

      val r = master.guess(guess.mkString)
      if (r == 6) return

      // filter down the candidate list
      currentList = currentList.filter(_.zip(guess).count(z => z._1 == z._2) == r)
    }
  }

  def main(args: Array[String]): Unit = {
    println(findSecretWord(Array("acckzz","ccbazz","eiowzz","abcczz"), new Master))
  }
}
