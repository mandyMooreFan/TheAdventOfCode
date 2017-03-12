import org.scalatest.{Matchers, WordSpecLike}

class DirectionsTest extends WordSpecLike with Matchers {
  "Direction" should {
    val input = "R22"
    val direction = Directions(input)

    "return the first character as Right or Left" in {
      direction.whichWay should equal('R')
    }
    "return all characters after the first as the HowMany" in {
      direction.howMany should equal(22)
    }
  }
}
