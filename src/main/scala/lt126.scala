// https://leetcode.com/problems/word-ladder-ii/
object lt126 {
  import scala.annotation.tailrec
  import scala.collection.mutable

  def findLadders(start: String, end: String, wordList: List[String]): List[List[String]] = {
    val neighbourMap = mutable.Map[String, Set[String]]()
    val distance = mutable.Map[String, Int]()
    val wordSet = wordList.toSet
    val queue = mutable.Queue[String]()

    def wordDistance(s1: String, s2: String): Int = (s1 zip s2).map(c => if (c._1 == c._2) 0 else 1).sum

    def isOneCharTransform(s1: String, s2: String): Boolean = wordDistance(s1, s2) == 1

    @tailrec
    def bfs(): Boolean = {
      if (queue.isEmpty) return false
      if (queue.contains(end)) return true
      val list = queue.dequeueAll(_ => true)
      val level = distance(list.head)
      val neighbors = list.flatMap(o => neighbourMap.getOrElseUpdate(o, getNeighbors(o)))
      neighbors.filterNot(distance.contains).foreach(o => {
        distance(o) = level + 1
        queue.enqueue(o)
      })
      bfs()
    }

    def dfs(curr: List[String], level: Int): List[List[String]] = {
      if (curr.isEmpty) return Nil
      if (curr.head == end) return List(curr)
      val neighbors = neighbourMap.getOrElse(curr.head, return Nil).filter(distance.getOrElse(_, -1) == level)
      neighbors.flatMap(n => dfs(n :: curr, level + 1)).toList
    }

    def getNeighbors(str: String) = {
      wordSet.filter(s => isOneCharTransform(str, s))
    }

    queue.enqueue(start)
    distance(start) = 0
    bfs()
    dfs(List(start), 1).map(_.reverse)
  }

  def findLadders2(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
    val wordSet = wordList.to(mutable.Set)

    var neighbors = mutable.Map[String, mutable.Set[String]]()

    def expandc(i: Int, builder: StringBuilder): Iterator[String] = new Iterator[String]{
      var c: Char = ('a' - 1).toChar

      override def hasNext: Boolean = c match{
        case 'z' => false
        case _   => true
      }

      override def next(): String = {
        c = (c+1).toChar
        builder.setCharAt(i, c)
        builder.toString()
      }
    }

    def expand(word: String): Iterator[String] = {
      (0 until word.length).iterator.flatMap(i => {
        val builder = new StringBuilder(word)
        expandc(i, builder)
      })
    }

    @tailrec
    def bfs(q: List[String], wordSet: mutable.Set[String], endWord:String): Unit ={
      if(q.isEmpty) return
      var done = false
      val newWordSet = mutable.Set[String]() ++= wordSet
      val new_q = q.flatMap(word => expand(word).filter(newWord => {
        if(done && newWord != endWord) false
        else if(!wordSet.contains(newWord)) false
        else{
          neighbors += ((newWord, neighbors.getOrElse(newWord, mutable.Set()).addOne(word)))
          if(newWord == endWord) {
            done = true
            false
          } else if(newWordSet.contains(newWord)){
            newWordSet -= newWord
            true
          } else{
            false
          }
        }
      }))
      if(done) return
      else bfs(new_q, newWordSet, endWord)
    }

    bfs(List(beginWord), wordSet, endWord)

    def backtrack(neighbors: mutable.Map[String, mutable.Set[String]], beginWord:String, endWord:String): List[List[String]] ={
      def prepend_neighbor(path: List[String]): List[List[String]] ={
        val first = path.head
        neighbors.get(first) match {
          case None    => Nil
          case Some(ns)=> ns.toList.map(n => n::path)
        }
      }
      @tailrec
      def get_res(res: List[List[String]], beginWord:String): List[List[String]]={
        res match{
          case Nil => Nil
          case res =>
            res.filter(_.head == beginWord) match{
              case Nil => get_res(res.flatMap(prepend_neighbor), beginWord)
              case _   => res
            }
        }
      }

      get_res(List(List(endWord)), beginWord)
    }

    backtrack(neighbors, beginWord, endWord)
  }

  def main(args: Array[String]): Unit = {
    val start = "hit"
    val end = "cog"
    val wordList = List("hot","dot","dog","lot","log","cog")
    findLadders(start, end, wordList).foreach(println(_))
  }
}
