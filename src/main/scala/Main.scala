import FormatTable.formatTable
import InputDouble.inputDouble
import Taylor.multipleTaylorRec
import Taylor.taylor

import scala.annotation.tailrec
import scala.io.StdIn

object Hello {
  def main(args: Array[String]): Unit = {
    try {
      val startX = inputDouble("Input start x")
      if(Math.abs(startX) > 1) throw new Exception("X must be in [-1, 1] range")
      val endX = inputDouble("Input end x")
      if(Math.abs(endX) > 1) throw new Exception("X must be in [-1, 1] range")
      val dx = inputDouble("Input step")
      if(dx == 0) throw new Exception("Step must not be zero")
      val e = inputDouble("Input accuracy")
      if(e <= 0) throw new Exception("Accuracy must be greater than zero")

      println(
        formatTable(
          Seq("x", "f(x)", "Taylor(x)", "TI (Taylor Iterations)") +:
            multipleTaylorRec(
              Math.min(startX, endX), 
              Math.max(startX, endX), 
              Math.abs(dx), 
              e, 
              taylor, 
              Math.atan
            )
        )
      )
    } catch {
      case e: NumberFormatException => {
        println("Not a number!")
        main(Array())
      }
      case e: Exception => {
        println(e.getMessage)
        main(Array())
      }
    }
  }
}