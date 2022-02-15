object FormatTable {
  def formatTable(table: Seq[Seq[Any]]): String = {
    if (table.isEmpty) return ""

    val columnWidths = table
      .transpose
      .map(_.map(cell => if (cell == null) 0 else cell.toString.length).max + 2)
    val rows = table
      .map(
        _.zip(columnWidths)
          //.map { case (item: Any, size: Int) => (f" ${size - 1}%s").format(item) }
          .map{ case (item: Any, size: Int) => (" %-" + (size - 1) + "s").format(item) }
          //.map{t:(Any, Int) => (" %-" + (t._2 - 1) + "s").format(t._1)}
          //.map(t => (" %-" + (t._2 - 1) + "s").format(t._1))
          .mkString("|", "|", "|")
      )

    val separator = columnWidths.map("-" * _).mkString("+", "+", "+")
    (separator +: rows.head +: separator +: rows.tail :+ separator).mkString("\n")
  }
}
