// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
object lt17 {
  def letterCombinations(digits: String): List[String] = {
    val map = Map(
      '2' -> "abc", '3' -> "def",
      '4' -> "ghi", '5' -> "jkl", '6' -> "mno",
      '7' -> "pqrs", '8' -> "tuv", '9' -> "wxyz",
    ).view.mapValues(_.toSeq).toMap

    def helper(digits: Seq[Char]): Seq[Seq[Char]] = {
      digits match {
        case Seq(h) => map(h).map(Seq(_))
        case Seq(h, t @ _ *) =>
          map(h).flatMap(x => helper(t).map(y => x +: y))
      }
    }

    if (digits.isEmpty) Nil else helper(digits.toSeq).map(_.mkString).toList
  }

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"))
  }
}
