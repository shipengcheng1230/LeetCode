import scala.annotation.tailrec

object lt726 {

  case class Elem(l: Map[String, Int]) {
    def +(that: Elem): Elem =
      Elem(l.foldLeft(that.l)((acc, x) => {
        acc.updated(x._1, acc.getOrElse(x._1, 0) + x._2)
      }))

    def *(that: Int): Elem = Elem(l.view.mapValues(_ * that).toMap)
  }

  val zero: Elem = Elem(Map.empty[String, Int])

  @tailrec
  def f(l: List[Char], acc: List[Elem]): List[Elem] = l match {
    case '(' :: t => f(t, zero :: acc)
    case ')' :: t => f(t, update(acc, zero))
    case h :: t if h.isLetter => f(t.dropWhile(x => x.isLower | x.isDigit), getFirst(l) :: acc)
    case h :: t if h.isDigit => f(t.dropWhile(x => x.isDigit), (acc.head * getInt(l)) :: acc.tail)
  }

  def getInt(l: List[Char]): Int = (l.takeWhile(_.isDigit).mkString).toInt

  def getFirst(l: List[Char]): Elem = {
    val part = l.tail.takeWhile { ch => ch.isLower || ch.isDigit }
    val p1 = part takeWhile (_.isLower)
    val p2 = part dropWhile (_.isLower)
    val cnt = p2 match {
      case Nil => 1
      case _ => p2.mkString.toInt
    }
    Elem(Map((l.head :: p1).mkString -> cnt))
  }

  @tailrec
  def update(mem: List[Elem], acc: Elem = zero): List[Elem] = mem match {
    case `zero` :: t => acc :: t
    case h :: t => update(t, h + acc)
    case _ => Nil
  }

  def countOfAtoms(formula: String): String = {
    f(formula.toList, Nil).reduce(_ + _).l.toSeq.sortBy(_._1).map { case (k, 1) => k case (k, v) => k + v.toString }.mkString
  }

}
