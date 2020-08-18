// https://leetcode.com/problems/design-hashmap/
object lt706 {
  class MyHashMap() {
    import scala.collection.mutable
    import scala.util.control.Breaks._

    case class Pair(var key: Int, var value: Int)

    class Bucket {
      val bucket: mutable.ListBuffer[Pair] = mutable.ListBuffer.empty[Pair]

      def get(key: Int): Int = {
        bucket.foreach(x => if (x.key == key) return x.value)
        -1
      }

      def update(key: Int, value: Int): Unit = {
        var found = false
        bucket.foreach(x => {
          if (x.key == key) {
            x.value = value
            found = true
          }
        })
        if (!found) bucket.addOne(Pair(key, value))
      }

      def remove(key: Int): Unit = {
        breakable {
          bucket.indices.foreach(i => {
            if (bucket(i).key == key) {
              bucket.remove(i)
              break() // need break since `i` will exceed range
            }
          })
        }
      }
    }

    /** Initialize your data structure here. */
    val space = 2069
    val table: Seq[Bucket] = (0 until space).map(_ => new Bucket)

    /** value will always be non-negative. */
    def put(key: Int, value: Int): Unit = {
      table(key % space).update(key, value)
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    def get(key: Int): Int = {
      table(key % space).get(key)
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    def remove(key: Int): Unit = {
      table(key % space).remove(key)
    }

  }
}
