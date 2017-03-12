
object Directions {

  val Right = "R"
  val Left = "L"
}

case class Directions(stringValue: String) {
  val whichWay = stringValue(0)
  val howMany = stringValue.substring(1).toInt
}
