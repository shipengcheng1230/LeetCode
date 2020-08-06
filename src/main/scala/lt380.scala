object lt380 {

  import scala.collection.mutable
  import scala.util.Random

  val list = mutable.ArrayBuffer.empty[Int]
  val map = mutable.Map.empty[Int, Int]
  val rand = new Random()

  def insert(`val`: Int): Boolean = {
    if (map.contains(`val`)) false
    else {
      map.update(`val`, list.length)
      list.append(`val`)
      true
    }
  }

  def remove(`val`: Int): Boolean = {
    if (!map.contains(`val`)) false
    else {
      val index = map(`val`)
      val last = list(list.length - 1) // list.last O(n)
      list.update(index, last)
      map.update(last, index)
      list.trimEnd(1)
      map.remove(`val`)
      true
    }
  }

  def getRandom(): Int = {
    list(rand.nextInt(list.length))
  }
}
