// https://leetcode.com/problems/fizz-buzz/
object lt412 {
  def fizzBuzz(n: Int): List[String] = {
    (1 to n).map(i => {
      if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
      else if (i % 3 == 0) "Fizz"
      else if (i % 5 == 0) "Buzz"
      else s"${i}"
    }).toList
  }

  // use Map when condition grows up
}
