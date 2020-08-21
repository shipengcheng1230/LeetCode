// https://leetcode.com/problems/utf-8-validation/
object lt393 {
  def validUtf8(data: Array[Int]): Boolean = {
    var numberOfBytesToProcess = 0
    data.indices.foreach(i => {
      val binRep = data(i).toBinaryString
      val binRep2 = if (binRep.length >= 8) binRep.takeRight(8) else "00000000".substring(binRep.length % 8) + binRep
      if (numberOfBytesToProcess == 0) {
        var j = 0
        while (j < binRep2.length && binRep2(j) == '1') {
          numberOfBytesToProcess += 1
          j += 1
        }
        if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1)
          return false

      } else {
        if (binRep2(0) != '1' || binRep2(1) != '0')
          return false
      }
      if (numberOfBytesToProcess != 0) numberOfBytesToProcess -= 1
    })
    numberOfBytesToProcess == 0
  }

  def main(args: Array[String]): Unit = {
    println(validUtf8(Array(197,130,1)))
  }
}
