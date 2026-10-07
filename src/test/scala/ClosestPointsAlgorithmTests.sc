class Cls extends munit.FunSuite {
  val clsPts = new ClosestPointsAlgoritihm()

  test("puntos basicos (1,2)(3,2)") {
    assert(clsPts.calculateDistanceTwoPoints(List(1,2),List(3,2))==2.0)
  }

  test("puntos basicos (1,2)(3,2) pero no da") {
    assert(clsPts.calculateDistanceTwoPoints(List(1,2),List(3,2))== 4.0)
  }
  test("puntos mas dificiles (2,9)(10,23)"){
    assert(clsPts.calculateDistanceTwoPoints(List(2,9),List(10,23))== 16.12 )
  }
}