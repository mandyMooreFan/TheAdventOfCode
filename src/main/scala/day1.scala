import scala.io.Source

object day1 extends App {
  val fileName = "day1.txt"
  val fileContents = Source.fromResource(fileName).getLines.mkString

  println(fileContents)
}