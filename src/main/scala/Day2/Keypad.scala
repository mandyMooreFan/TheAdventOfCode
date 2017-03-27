package Day2

import Day1.Coordinate

object Keypad extends Enumeration {

  val One, Two, Three, Four, Five, Six, Seven, Eight, Nine = Value

  def map(coordinate: Coordinate): Keypad.Value = coordinate match {
    case Coordinate(-1, 1) => One
    case Coordinate(0, 1) => Two
    case Coordinate(1, 1) => Three
    case Coordinate(-1, 0) => Four
    case Coordinate(0, 0) => Five
    case Coordinate(1, 0) => Six
    case Coordinate(-1, -1) => Seven
    case Coordinate(0, -1) => Eight
    case Coordinate(1, -1) => Nine
  }

  def boundaryCheck(coordinate: Coordinate): Boolean = {
    coordinate.x.abs > 1 || coordinate.y.abs > 1
  }
}