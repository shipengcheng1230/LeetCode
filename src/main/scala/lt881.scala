// https://leetcode.com/problems/boats-to-save-people/
object lt881 {
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    val sortedPeople = people.sortWith(_ > _)
    var ans = 0
    var i = 0
    var j = people.length - 1
    while (i <= j) {
      if (sortedPeople(i) + sortedPeople(j) <= limit) {
        i += 1
        j -= 1
      } else {
        i += 1
      }
      ans += 1
    }
    ans
  }
}
