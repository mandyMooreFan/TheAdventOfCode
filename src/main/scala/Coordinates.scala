
object Coordinates {
}

case class Coordinates(x: Int, y: Int, cardinalDirection: String) {

  def takeDirections(direction: Directions, currentCoordinates: Coordinates, cardinalDirection: String): Coordinates = {
    val orientMap = currentCoordinates.orientMap(direction, cardinalDirection)
    val whichWay = direction.whichWay
    val moveSpaces = direction.howMany * orientMap
    val newCardinalDirection = CardinalDirection().currentDirection(direction, cardinalDirection.toString)

    if (cardinalDirection.toString == CardinalDirection.North || cardinalDirection.toString == CardinalDirection.South)
      Coordinates(currentCoordinates.x + moveSpaces, currentCoordinates.y, newCardinalDirection)
    else {
      Coordinates(currentCoordinates.x, currentCoordinates.y + moveSpaces, newCardinalDirection)
    }
  }

  def orientMap(directions: Directions, cardinalDirection: String): Int = (directions.whichWay.toString, cardinalDirection) match {
    case (Directions.Left, CardinalDirection.North) => -1
    case (Directions.Right, CardinalDirection.North) => 1
    case (Directions.Left, CardinalDirection.South) => 1
    case (Directions.Right, CardinalDirection.South) => -1
    case (Directions.Left, CardinalDirection.East) => 1
    case (Directions.Right, CardinalDirection.East) => -1
    case (Directions.Left, CardinalDirection.West) => -1
    case (Directions.Right, CardinalDirection.West) => 1

  }

}
