object lt1268 {

  import scala.collection.mutable.{Map => MMap, ListBuffer => LB}

  class TrieNode {
    val children: MMap[Char, TrieNode] = MMap.empty[Char, TrieNode]
    var data: LB[String] = LB.empty[String]
  }

  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = {
    val root = new TrieNode
    var curr = root
    val res = LB.empty[List[String]]

    products.foreach(product => {
      product.foreach(c => {
        curr = curr.children.getOrElseUpdate(c, new TrieNode)
        curr.data.append(product)
      })
      curr = root
    })

    def gather(curr: TrieNode): List[String] = {
      curr.data.toList
    }

    def next(c: Char, start: TrieNode): TrieNode =
      if (start == null) null else start.children.getOrElseUpdate(c, null)

    curr = root
    searchWord.foreach(c => {
      curr = next(c, curr)
      if (curr != null) {
        res.addOne(gather(curr).sorted.take(3))
      } else res.addOne(List.empty[String])
    })
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val a = Array("mobile","mouse","moneypot","monitor","mousepad")
    val b = "mouse"
    print(suggestedProducts(a, b))
  }
}
