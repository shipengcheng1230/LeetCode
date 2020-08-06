import scala.collection.mutable

object lt353 {
  class SnakeGame(_width: Int, _height: Int, _food: Array[Array[Int]]) {

    val snake: mutable.ArrayDeque[(Int, Int)] = mutable.ArrayDeque.empty[(Int, Int)].addOne((0, 0))
    val directions = Map("U" -> (-1, 0), "L" -> (0, -1), "R" -> (0, 1), "D" -> (1, 0))
    val foods: mutable.ArrayDeque[(Int, Int)] = mutable.ArrayDeque.empty[(Int, Int)].addAll(_food.map(f => (f(0), f(1))))

    def move(direction: String): Int = {
      val newHead = (snake.head._1 + directions(direction)._1, snake.head._2 + directions(direction)._2)
      if (
        (newHead._1 < 0 || newHead._1 >= _height) ||
        (newHead._2 < 0 || newHead._2 >= _width) ||
        (snake.contains(newHead) && snake.last != newHead)) return -1

      if (foods.nonEmpty && foods.head == newHead) {
        snake.prepend(newHead)
        foods.removeHead()
      } else {
        snake.prepend(newHead)
        snake.removeLast()
      }
      snake.length - 1
    }

  }
}
