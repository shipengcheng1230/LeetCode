// https://leetcode.com/problems/subdomain-visit-count/
object lt811 {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    cpdomains
      .map(_.split(" "))
      .map(x => (
        x.head.toInt,
        x.last.split("\\.")
          .scanRight("")((x, acc) => if (acc.isEmpty) x else x + "." + acc).init
      ))
      .flatMap(x => x._2.map(_ -> x._1))
      .groupMapReduce(_._1)(_._2)(_ + _)
      .map(x => s"${x._2} ${x._1}")
      .toList
  }

  def main(args: Array[String]): Unit = {
    println(subdomainVisits(Array("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")))
  }
}
