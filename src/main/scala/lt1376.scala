// https://leetcode.com/problems/time-needed-to-inform-all-employees/
object lt1376 {
  def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {

    val manager2employee = manager.zipWithIndex.groupMap(_._1)(_._2)

    def dfs(id: Int, acc: Int): Int = {
      if (manager2employee.contains(id)) {
        manager2employee(id).map(x => dfs(x, acc + informTime(x))).max
      } else acc
    }

    dfs(headID, informTime(headID))
  }

  def main(args: Array[String]): Unit = {
    println(numOfMinutes(15, 0, Array(-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6), Array(1,1,1,1,1,1,1,0,0,0,0,0,0,0,0)))
  }
}
