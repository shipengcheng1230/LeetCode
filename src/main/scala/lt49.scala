import scala.collection.mutable

object l49 {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {

    val x = new mutable.HashMap[String, List[String]]()
    strs.foreach(
      str => {
        val key = stringCountKey(str)
        if (x.contains(key)) x.update(key, str :: x(key))
        else x.update(key, List(str))
      }
    )
    x.values.toList
  }

  def stringCountKey(str: String): String = {
    val x = Array.fill[Int](26)(0)
    str.foreach(c => x(c - 'a') = x(c - 'a') + 1)
    x.mkString("#")
  }
}