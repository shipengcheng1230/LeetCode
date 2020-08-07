import scala.collection.immutable.TreeSet

object lt315 {
  def countSmaller(nums: Array[Int]): List[Int] = {
    case class KV(idx: Int, value: Int) //just for readability
    implicit object KVOrdering extends Ordering[KV] { //we define a ordering for the RB Tree that will rule out duplicates
      override def compare(x: KV, y: KV): Int = {     //and order them such that larger indexes with equal value are larger in the Tree
        val cmp = Integer.compare(x.value, y.value)   //due to this when we query the number of smaller items they are not included
        if (cmp == 0) Integer.compare(x.idx, y.idx) else cmp
      }
    }
    //we add the index to each entry, then do a fold from the right side
    nums.zipWithIndex.map { case (value, idx) => KV(idx, value) }.foldRight((TreeSet.empty[KV], List.empty[Int]))(
      (ele, acc) => {
        val (tset: TreeSet[KV], res: List[Int]) = acc
        val ntset = tset + ele //at each iteration add the element to a RB Tree (TreeSet) - there are no duplicates due to the included index
        val size = ntset.size - ntset.from(ele).size //unlike in java .size is O(1) in the Scala implementation
        (ntset, size +: res) //prepend the size info at each step to a list
      })._2
  }
}
