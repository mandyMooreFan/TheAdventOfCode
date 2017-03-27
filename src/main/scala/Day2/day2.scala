package Day2

import Day1.Coordinate

import scala.io.Source


object day2 extends App {

  case object Pad extends Enumeration {
    val Key, Diamond = Value
  }

  val which = Pad.Diamond
  val fileName = "Day2/day2Part2.txt"
  val startingCoordinate = if (which == Pad.Key) Coordinate(0, 0) else Coordinate(-2, 0)
  val splitOnLines = Source.fromResource(fileName).getLines().toList

  splitOnLines.foldLeft(startingCoordinate, which) {
    case ((coordinate, which), items) =>
      val coord = Directions.handleDirections(items, coordinate, which)
      if (which == Pad.Key)
        println("Part 1 Password: " + Keypad.map(coord).toString)
      else {
        println("Part 2 Password: " + DiamondPad.map(coord).toString)
      }
      (coord, which)
  }
}
