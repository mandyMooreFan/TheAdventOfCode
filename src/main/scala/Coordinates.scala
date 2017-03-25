
object Coordinates {
}

case class Coordinates(x: Int, y: Int, cardinalDirection: CardinalDirection.Value) {

  def takeDirections(direction: Directions, currentCoordinates: Coordinates, cardinalDirection: CardinalDirection.Value): Coordinates = {
    val orientMap = currentCoordinates.orientMap(direction, cardinalDirection)
    val whichWay = direction.whichWay
    val moveSpaces = direction.howMany * orientMap
    val newCardinalDirection = CardinalDirection().currentDirection(direction, cardinalDirection)

    if (cardinalDirection == CardinalDirection.North || cardinalDirection == CardinalDirection.South)
      Coordinates(currentCoordinates.x + moveSpaces, currentCoordinates.y, newCardinalDirection)
    else {
      Coordinates(currentCoordinates.x, currentCoordinates.y + moveSpaces, newCardinalDirection)
    }
  }

  def orientMap(directions: Directions, cardinalDirection: CardinalDirection.Value): Int = (directions.whichWay, cardinalDirection) match {
    case (Directions.L, CardinalDirection.North) => -1
    case (Directions.R, CardinalDirection.North) => 1
    case (Directions.L, CardinalDirection.South) => 1
    case (Directions.R, CardinalDirection.South) => -1
    case (Directions.L, CardinalDirection.East) => 1
    case (Directions.R, CardinalDirection.East) => -1
    case (Directions.L, CardinalDirection.West) => -1
    case (Directions.R, CardinalDirection.West) => 1

  }

}
