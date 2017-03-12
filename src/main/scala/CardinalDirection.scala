
object CardinalDirection {
  val North = "North"
  val South = "South"
  val East = "East"
  val West = "West"

  val startingDirection = CardinalDirection.North
}

case class CardinalDirection() {

  def currentDirection(directions: Directions, cardinalDirection: String): String =
    (directions.whichWay.toString, cardinalDirection.toString) match {
      case (Directions.Right, CardinalDirection.North) => CardinalDirection.East
      case (Directions.Right, CardinalDirection.South) => CardinalDirection.West
      case (Directions.Right, CardinalDirection.East) => CardinalDirection.South
      case (Directions.Right, CardinalDirection.West) => CardinalDirection.North
      case (Directions.Left, CardinalDirection.North) => CardinalDirection.West
      case (Directions.Left, CardinalDirection.South) => CardinalDirection.East
      case (Directions.Left, CardinalDirection.East) => CardinalDirection.North
      case (Directions.Left, CardinalDirection.West) => CardinalDirection.South
    }
}
