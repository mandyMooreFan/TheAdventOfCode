
object Directions extends Enumeration {
  val R, L = Value
}

case class Directions(stringValue: String) {
  val whichWay = Directions.withName(stringValue(0).toString)
  val howMany = stringValue.substring(1).toInt
}
