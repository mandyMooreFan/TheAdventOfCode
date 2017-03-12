import org.scalatest.{Matchers, WordSpecLike}

class CardinalDirectionTest extends WordSpecLike with Matchers {
  "CardinalDirection" should {
    val direction = Directions("L3")

    "tack a direction and a cardinal direction and return the new cardinal direction" in {
      CardinalDirection().currentDirection(direction, CardinalDirection.North) should equal(CardinalDirection.West)
    }
  }
}
