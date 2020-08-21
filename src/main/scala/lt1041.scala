// https://leetcode.com/problems/robot-bounded-in-circle/
object lt1041 {
  def isRobotBounded(instructions: String): Boolean = {
    var pre = (0, 0)
    var dirs = Array((1, 0), (0, -1), (-1, 0), (0, 1))
    var i = 0
    instructions.foreach(ins => {
      if (ins == 'G')
        pre = (pre._1 + dirs(i)._1, pre._2 + dirs(i)._2)
      else if (ins == 'L')
        i = (i - 1 + 4) % 4
      else if (ins == 'R')
        i = (i + 1) % 4
    })
    pre == (0, 0) || i != 0
  }
}
