// https://leetcode.com/problems/design-parking-system/
object lt1603 {
  class ParkingSystem(_big: Int, _medium: Int, _small: Int) {
    import scala.collection.mutable.Map

    val cache = Map(1 -> _big, 2 -> _medium, 3 -> _small)

    def addCar(carType: Int): Boolean = {
      if (cache(carType) == 0) false
      else {
        cache.update(carType, cache(carType) - 1)
        true
      }
    }
  }
}
