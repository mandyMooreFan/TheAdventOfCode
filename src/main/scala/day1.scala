import scala.io.Source

object day1 extends App {

  val startingCoordinate = (Seq(Coordinate(0, 0)), CardinalDirection.North)
  val fileName = "day1Test.txt"
  val fileCommaSplit = Source.fromResource(fileName).getLines.mkString.split(",")

  val route = fileCommaSplit.foldLeft(startingCoordinate) {
    case ((coordinates, cardinalDirection), item) =>
      Coordinates.takeDirections(Directions(item.trim), coordinates, cardinalDirection)
  }
  val visitedTwice = route._1.find(coordinate => route._1.count(_ == coordinate) > 1).getOrElse(Coordinate(0,0))
  val finalSpot = route._1.last

  println("The distance to the final direction is: " + (finalSpot.x.abs + finalSpot.y.abs))
  println("The first spot visited twice is:" + (visitedTwice.x.abs + visitedTwice.y.abs))
  println(route)
  println(visitedTwice)
  println(finalSpot)
}