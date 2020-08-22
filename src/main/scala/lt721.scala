// https://leetcode.com/problems/accounts-merge/
object lt721 {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    import scala.collection.mutable

    val emailToName = mutable.Map.empty[String, String]
    val graph = mutable.Map.empty[String, mutable.ArrayBuffer[String]]
    accounts.foreach(account => {
      val name = account.head
      val emails = account.tail
      val first = emails.head
      emails.foreach(email => {
        graph.update(email, graph.getOrElse(email, mutable.ArrayBuffer.empty[String]).append(first))
        graph.update(first, graph.getOrElse(first, mutable.ArrayBuffer.empty[String]).append(email))
        emailToName.update(first, name)
      })
    })
    val seen = mutable.Set.empty[String]
    val ans = mutable.ListBuffer.empty[List[String]]
    emailToName.keysIterator.foreach(email => {
      if (!seen.contains(email)) {
        seen.addOne(email)
        val stack = mutable.Stack.empty[String]
        stack.push(email)
        val component = mutable.ArrayBuffer.empty[String]
        while (stack.nonEmpty) {
          val node = stack.pop()
          component.addOne(node)
          graph(node).foreach(neighbor => {
            if (!seen.contains(neighbor)) {
              seen.addOne(neighbor)
              stack.push(neighbor)
            }
          })
        }
        component.sortInPlace()
        component.prepend(emailToName(email))
        ans.addOne(component.toList)
      }
    })
    ans.toList
  }
}
