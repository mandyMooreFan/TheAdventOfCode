package Day3

import scala.io.Source


object Day3 extends App {
  val fileName = "Day3/day3.txt"
  val testedTriangles: List[Boolean] = List()
  val splitOnLines = Source.fromResource(fileName).getLines().toList

  val output = splitOnLines.foldLeft(testedTriangles) {
    (testedTriangles, triangleInstructions) =>
      val splitTriangle = triangleInstructions.trim.split("\\s+")
      testedTriangles :+ Triangle(splitTriangle(0).toInt,splitTriangle(1).toInt,splitTriangle(2).toInt).isValid()
  }
  println("Number of Valid Triangles: " + output.count(_ == true))
}
