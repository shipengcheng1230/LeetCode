import java.io.OutputStream

import scala.annotation.tailrec

object Fudge {
  implicit class BlurpConsole(c: scala.Console.type) {
    def setOut(x: OutputStream): Unit = ()
  }
}
import Fudge._

object lt240 {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty) return false

    val nrow = matrix.length
    val ncol = matrix.head.length

    @tailrec
    def traverse(i: Int, j: Int): Boolean = {
      if (i < 0 || j >= ncol) false
      else {
        if (matrix(i)(j) == target) true
        else if (matrix(i)(j) > target) traverse(i-1, j)
        else traverse(i, j+1)
      }
    }

    traverse(nrow-1, 0)
  }
}