
object Coordinates {

  def move(directions: Directions, cardinalDirection: CardinalDirection.Value,
           currentCoordinate: Coordinate): Coordinate = (directions.whichWay, cardinalDirection) match {
    case (Directions.L, CardinalDirection.North) => Coordinate(currentCoordinate.x - 1, currentCoordinate.y)
    case (Directions.R, CardinalDirection.North) => Coordinate(currentCoordinate.x + 1, currentCoordinate.y)
    case (Directions.L, CardinalDirection.South) => Coordinate(currentCoordinate.x + 1, currentCoordinate.y)
    case (Directions.R, CardinalDirection.South) => Coordinate(currentCoordinate.x - 1, currentCoordinate.y)
    case (Directions.L, CardinalDirection.East) => Coordinate(currentCoordinate.x, currentCoordinate.y + 1)
    case (Directions.R, CardinalDirection.East) => Coordinate(currentCoordinate.x, currentCoordinate.y - 1)
    case (Directions.L, CardinalDirection.West) => Coordinate(currentCoordinate.x, currentCoordinate.y - 1)
    case (Directions.R, CardinalDirection.West) => Coordinate(currentCoordinate.x, currentCoordinate.y + 1)
  }

  def takeDirections(direction: Directions, coordinates: Seq[Coordinate],
                     cardinalDirection: CardinalDirection.Value): (Seq[Coordinate], CardinalDirection.Value) = {
    val howMany = direction.howMany
    val newCardinalDirection = CardinalDirection().currentDirection(direction, cardinalDirection)

    1.to(howMany).foldLeft(coordinates, newCardinalDirection) {
      case ((coordinates: Seq[Coordinate], newCardinalDirection),howMany) =>
        (coordinates :+ move(direction, cardinalDirection, coordinates.last), newCardinalDirection)
    }
  }
}

case class Coordinate(x: Int, y: Int) {
}
