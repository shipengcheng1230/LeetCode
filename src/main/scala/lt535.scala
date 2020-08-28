// https://leetcode.com/problems/encode-and-decode-tinyurl/
object lt535 {
  class Codec {
    import scala.collection.mutable
    import scala.util.Random

    val alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val map = mutable.Map.empty[String, String]
    var key = getRand

    def getRand: String = {
      (0 until 6).map(_ => alphabet(Random.nextInt(62))).mkString("")
    }

    // Encodes a URL to a shortened URL.
    def encode(longURL: String): String = {
      if (map.contains(key))
        key = getRand

      map.update(key, longURL)
      "http://tinyurl.com/" + key
    }

    // Decodes a shortened URL to its original URL.
    def decode(shortURL: String): String = {
      map(shortURL.replace("http://tinyurl.com/", ""))
    }
  }
}
