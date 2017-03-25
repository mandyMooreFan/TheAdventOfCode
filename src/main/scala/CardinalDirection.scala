
object CardinalDirection extends Enumeration {
  val North, South, East, West = Value

  val startingDirection = CardinalDirection.North
}

case class CardinalDirection() {

  def currentDirection(directions: Directions, cardinalDirection: CardinalDirection.Value): CardinalDirection.Value =
    (directions.whichWay, cardinalDirection) match {
      case (Directions.R, CardinalDirection.North) => CardinalDirection.East
      case (Directions.R, CardinalDirection.South) => CardinalDirection.West
      case (Directions.R, CardinalDirection.East) => CardinalDirection.South
      case (Directions.R, CardinalDirection.West) => CardinalDirection.North
      case (Directions.L, CardinalDirection.North) => CardinalDirection.West
      case (Directions.L, CardinalDirection.South) => CardinalDirection.East
      case (Directions.L, CardinalDirection.East) => CardinalDirection.North
      case (Directions.L, CardinalDirection.West) => CardinalDirection.South
    }
}
