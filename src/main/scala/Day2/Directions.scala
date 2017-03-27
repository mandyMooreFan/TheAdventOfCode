package Day2

import Day1.Coordinate

object Directions extends Enumeration {
  val U, D, L, R = Value

  def move(direction: Direction, coordinate: Coordinate) = {

  }
}

case class Direction(item: String) {
  val whichWay = item.trim
}


