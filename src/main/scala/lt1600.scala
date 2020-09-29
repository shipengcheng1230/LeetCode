// https://leetcode.com/problems/throne-inheritance/
object lt1600 {
  class ThroneInheritance(_kingName: String) {
    import scala.collection.mutable.{Map, Set, ListBuffer}

    val children = Map.empty[String, ListBuffer[String]]
    val dead = Set.empty[String]

    def birth(parentName: String, childName: String): Unit = {
      children.getOrElseUpdate(parentName, ListBuffer.empty[String]).addOne(childName)
    }

    def death(name: String): Unit = {
      dead.addOne(name)
    }

    def getInheritanceOrder: List[String] = {
      dfs(_kingName, ListBuffer.empty[String]).toList
    }

    def dfs(node: String, ans: ListBuffer[String]): ListBuffer[String] = {
      if (!dead.contains(node)) ans.addOne(node)
      children.getOrElse(node, None).iterator.foreach(c => dfs(c, ans))
      ans
    }
  }
}
