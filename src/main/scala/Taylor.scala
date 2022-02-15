import scala.annotation.tailrec

object Taylor {
  def multipleTaylorRec(
                         curX: Double,
                         endX: Double,
                         dx: Double,
                         e: Double,
                         taylor: (Double, Int) => Double,
                         function: (Double) => Double
                       ): Seq[Seq[Any]] = {
    if(curX > endX) return Seq()
    val result = taylorSum(curX, e, taylor)
    Seq(curX, function(curX), result.head, result.last) +:
      multipleTaylorRec((curX * 1000 + dx * 1000) / 1000, endX, dx, e, taylor, function)
  }
  
  @tailrec
  def taylorSum(
                 x: Double,
                 e: Double,
                 taylor: (Double, Int) => Double,
                 sum: Double = 0,
                 n: Int = 0
               ): List[Double] = {
    val value = taylor(x, n)
    if (n >= 500 || Math.abs(value) < e) List(sum, n + 1)
    else taylorSum(x, e, taylor, sum + value, n + 1)
  }

  def taylor(x: Double, n: Int): Double = {
    Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1)
  }
}
