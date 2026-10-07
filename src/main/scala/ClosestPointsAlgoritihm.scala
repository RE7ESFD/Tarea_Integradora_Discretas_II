class ClosestPointsAlgoritihm {

  import scala.annotation.tailrec
  import scala.math.*

  def calculateDistanceTwoPoints(points1: List[Float], points2: List[Float]): Float = {

    @tailrec
    def recursionDistance(tailX: List[Float], tailY: List[Float], acumulator: Float): Float = {(tailX, tailY) match {
        case (Nil, Nil) => (sqrt(acumulator)).toFloat
        case (x :: xs, y :: ys) => recursionDistance(xs, ys, acumulator + ((x - y) * (x - y)))
      }
    }

    recursionDistance(points1, points2, 0)
  }


}