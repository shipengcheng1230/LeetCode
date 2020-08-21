// https://leetcode.com/problems/all-oone-data-structure/
object lt432 {
  class AllOne() {

    import scala.collection.mutable

    case class KV(key: Int, freq: Int, prev: KV, next: KV)

    val cache = mutable.Map.empty[String, Int]

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    def inc(key: String): Unit = {
      ???
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    def dec(key: String): Unit = {
      ???
    }

    /** Returns one of the keys with maximal value. */
    def getMaxKey(): String = {
      ???
    }

    /** Returns one of the keys with Minimal value. */
    def getMinKey(): String = {
      ???
    }

  }
}
