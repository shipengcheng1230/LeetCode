// https://leetcode.com/problems/daily-temperatures/
object lt739 {
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    import scala.collection.mutable
    val ans =  Array.fill(T.length)(0)
    val stack = mutable.Stack.empty[(Int, Int)]
    T.indices.foreach(i => {
      stack.headOption match {
        case None => stack.push((T(i), i))
        case Some(c) =>
          while (stack.nonEmpty && stack.head._1 < T(i)) {
            ans(stack.head._2) = i - stack.head._2
            stack.pop()
          }
          stack.push((T(i), i))
      }
    })
    ans
  }
}
