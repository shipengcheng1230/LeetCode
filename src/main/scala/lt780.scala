// https://leetcode.com/problems/reaching-points/
object lt780 {
  def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {

    var (_tx, _ty) = (tx, ty)
    while (_tx >= sx && _ty >= sy && _tx != _ty) {
      if (_tx > _ty) {
        if (_ty > sy) _tx %= _ty
        else return (_tx - sx) % _ty == 0
      } else {
        if (_tx > sx) _ty %= _tx
        else return (_ty - sy) % _tx == 0
      }
    }
    _tx == sx && _ty == sy
  }
}
