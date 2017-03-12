import scala.io.Source

object day1 extends App {

  val startingCoordinates = Coordinates(0, 0, CardinalDirection.startingDirection)
  val fileName = "day1.txt"
  val fileContents = Source.fromResource(fileName).getLines.mkString

  val finalSpot = fileContents.split(",").foldLeft(startingCoordinates) { (coordinates: Coordinates, item) =>
    coordinates.takeDirections(Directions(item.trim), coordinates, coordinates.cardinalDirection)
  }
  println(finalSpot)
}