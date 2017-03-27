package Day2

import Day1.Coordinate

import scala.io.Source


object day2 extends App {

  val startingCoordinate = Coordinate(0, 0)
  val fileName = "Day2/day2Test.txt"
  val splitOnLines = Source.fromResource(fileName).getLines().toList

  splitOnLines.foldLeft(startingCoordinate) {
    (coordinate, item) =>
      println(coordinate, item)
      coordinate
  }
}
