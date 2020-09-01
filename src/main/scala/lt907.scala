// https://leetcode.com/problems/sum-of-subarray-minimums/
object lt907 {
  def sumSubarrayMins(A: Array[Int]): Int = {
    import scala.collection.mutable

    val n = A.length
    val stack = mutable.Stack.empty[Int]
    val left = A.indices.map(_ + 1).toArray
    val right = A.indices.map(n - _).toArray

    A.indices.foreach(i => {
      while (stack.nonEmpty && A(stack.head) > A(i))
        stack.pop()
      left(i) = if (stack.isEmpty) i + 1 else i - stack.head
      stack.push(i)
    })

    stack.clear()
    A.indices.foreach(i => {
      while (stack.nonEmpty && A(stack.head) > A(i)) {
        right(stack.head) = i - stack.head
        stack.pop()
      }
      stack.push(i)
    })

    val mod = (1e9 + 7).toInt
    A.indices.foldLeft(0)((acc, i) => (acc + A(i) * left(i) * right(i)) % mod)
  }
}
