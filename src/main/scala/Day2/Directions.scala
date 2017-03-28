package Day2

import Day1.Coordinate
import Day2.day2.Pad

object Directions extends Enumeration {
  val U, D, L, R = Value

  def handleDirections(items: String, coordinate: Coordinate, which: Pad.Value): Coordinate = {
    val itemsArray = items.split("")
    itemsArray.foldLeft(coordinate) {
      (coordinate, item) =>
        Directions.move(Direction(item), coordinate, which)
    }
  }

  def move(direction: Direction, coordinate: Coordinate, which: Pad.Value): Coordinate = {
    val newCoordinate = direction.whichWay match {
      case U => Coordinate(coordinate.x, coordinate.y + 1)
      case D => Coordinate(coordinate.x, coordinate.y - 1)
      case L => Coordinate(coordinate.x - 1, coordinate.y)
      case R => Coordinate(coordinate.x + 1, coordinate.y)
    }
    val checkOfBoundary = which match {
      case Pad.Key => Keypad.boundaryCheck(newCoordinate)
      case Pad.Diamond => DiamondPad.boundaryCheck(newCoordinate)
    }
    if (checkOfBoundary) coordinate else newCoordinate
  }
}

case class Direction(item: String) {
  val whichWay = Directions.withName(item.trim)
}


