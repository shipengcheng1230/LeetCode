// https://leetcode.com/problems/alien-dictionary/
object lt269 {
  import scala.annotation.tailrec
  import scala.collection.mutable

  def alienOrder(words: Array[String]): String = {

    val inDegreeMap = words.sliding(2, 1)
      .foldLeft(words.flatMap(_.toSet[Char]).map(_ -> Set.empty[Char]).toMap)(
        (acc, words) => {
          if ((words.head startsWith words.last) && (words.head != words.last)) return ""
          else {
            (words.head zip words.last).find(c => c._1 != c._2) match {
              case None => acc
              case Some(x) => acc ++ Map(x._2 -> (acc(x._2) incl x._1))
            }
          }
        }
      )

    @tailrec
    def topologySort(curr: Map[Char, Set[Char]], letters: List[Char]): Option[List[Char]] = {
      val (zero, nonzero) = curr.partition(_._2.isEmpty)
      (zero.isEmpty, nonzero.isEmpty) match {
        case (true, false) => None
        case (true, true) => Some(letters)
        case _ => topologySort(nonzero.view.mapValues(_ removedAll zero.keySet).toMap, zero.keys.toList ++: letters)
      }
    }

    topologySort(inDegreeMap, List.empty[Char]) match {
      case None => ""
      case Some(x) => x.reverse.mkString("")
    }
  }

  def alienOrder2(words: Array[String]): String = {
    val inDegreeMap = mutable.Map(words.flatMap(_.toSet).map(_ -> Set.empty[Char]).toIndexedSeq: _*)
    for (word2 <- words.sliding(2, 1)) {
      if (word2.head.startsWith(word2.last) && word2.head != word2.last) return ""
      else {
        (word2.head zip word2.last).find(c => c._1 != c._2) match {
          case None =>
          case Some(x) => inDegreeMap.update(x._2, inDegreeMap(x._2) + x._1)
        }
      }
    }

    val seen = mutable.Map.empty[Char, Boolean]
    val output = mutable.ListBuffer.empty[Char]

    def dfs(c: Char): Boolean = {
      if (seen contains c) seen(c)
      else {
        seen.update(c, false)
        inDegreeMap(c).foreach(x => if (!dfs(x)) return false)
        seen.update(c, true)
        output += c
        true
      }
    }

    if (!inDegreeMap.keysIterator.forall(dfs)) ""
    else output.mkString("")
  }

  def main(args: Array[String]): Unit = {
    print(alienOrder(List("wrt","wrf","er","ett","rftt").toArray))
  }
}