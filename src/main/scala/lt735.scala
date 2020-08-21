// https://leetcode.com/problems/asteroid-collision/
object lt735 {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {

    val stack = scala.collection.mutable.Stack.empty[Int]

    asteroids.foreach(ast => {
      while (stack.nonEmpty && stack.head > 0 && stack.head < -ast)
        stack.pop()
      if (stack.isEmpty || ast > 0 || stack.head < 0)
        stack.push(ast)
      else if (ast < 0 && stack.head == -ast)
        stack.pop()
    })
    stack.toArray.reverse
  }
}
