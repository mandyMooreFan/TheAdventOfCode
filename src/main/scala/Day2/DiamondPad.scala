package Day2

import Day1.Coordinate

object DiamondPad extends Enumeration {

  val One, Two, Three, Four, Five, Six, Seven, Eight, Nine, A, B, C, D = Value

  def map(coordinate: Coordinate): DiamondPad.Value = coordinate match {
    case Coordinate(0, 2) => One
    case Coordinate(-1, 1) => Two
    case Coordinate(0, 1) => Three
    case Coordinate(1, 1) => Four
    case Coordinate(-2, 0) => Five
    case Coordinate(-1, 0) => Six
    case Coordinate(0, 0) => Seven
    case Coordinate(1, 0) => Eight
    case Coordinate(2, 0) => Nine
    case Coordinate(-1, -1) => A
    case Coordinate(0, -1) => B
    case Coordinate(1, -1) => C
    case Coordinate(0, -2) => D

  }

  def boundaryCheck(coordinate: Coordinate): Boolean = {
    coordinate.x.abs > 2 ||
      coordinate.y.abs > 2 ||
      (coordinate.y.abs == 2 && coordinate.x.abs > 0) ||
      (coordinate.y.abs > 0 && coordinate.x.abs == 2)
  }
}
