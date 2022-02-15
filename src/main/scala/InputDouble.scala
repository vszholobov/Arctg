import scala.io.StdIn

object InputDouble {
  def inputDouble(phrase: String): Double = {
    println(phrase)
    StdIn.readLine().toDouble
  }
}
