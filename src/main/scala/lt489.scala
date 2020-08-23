// https://leetcode.com/problems/robot-room-cleaner/solution/
object lt489 {

  class Robot {
    def move(): Boolean = true
    def turnLeft(): Unit = {}
    def turnRight(): Unit = {}
    def clean(): Unit = {}
  }

  def cleanRoom(robot: Robot): Unit = {

    import scala.collection.mutable

    val visited = mutable.Set.empty[(Int, Int)]
    val directions = Array((-1, 0), (0, 1), (1, 0), (0, -1))

    def go_back(): Unit = {
      robot.turnRight()
      robot.turnRight()
      robot.move()
      robot.turnRight()
      robot.turnRight()
    }
    def backtrack(cell: (Int, Int) = (0, 0), d: Int = 0): Unit = {
      visited.addOne(cell)
      robot.clean()
      directions.indices.foreach(i => {
        val new_d = (d + i) % 4
        val new_cell = (cell._1 + directions(new_d)._1, cell._2 + directions(new_d)._2)
        if (!visited.contains(new_cell) && robot.move()) {
          backtrack(new_cell, new_d)
          go_back()
        }
        robot.turnRight()
      })
    }
    backtrack()
  }
}
