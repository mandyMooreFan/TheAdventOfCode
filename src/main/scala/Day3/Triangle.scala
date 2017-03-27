package Day3


case class Triangle(a: Int, b: Int, c: Int) {

  def isValid(): Boolean = {
    a + b > c &&
    b + c > a &&
    c + a > b
  }
}
