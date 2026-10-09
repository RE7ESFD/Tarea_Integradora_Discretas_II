class ClosestPointsAlgoritihm {

  import scala.annotation.tailrec
  import scala.math.*

  def appendTR(inputL1: List[List[Int]], inputL2: List[List[Int]]): List[List[Int]] = {
    @tailrec
    def loop(l1: List[List[Int]], acc: List[List[Int]]): List[List[Int]] = l1 match {
      case Nil => acc
      case head :: tail => loop(tail, head :: acc)
    }

    loop(loop(inputL1, Nil), inputL2)
  }

  def getCord(point: List[Int],cord:Int) : Int =point match{
    case x::y::Nil => if (cord==0) x else y
  }

  @tailrec
   final def split(inputList: List[List[Int]], pivot: List[Int], cord:Int, minorsAcc: List[List[Int]], maxAcc: List[List[Int]]):(List[List[Int]], List[List[Int]]) =
    inputList match {
      case Nil => (minorsAcc.reverse, maxAcc.reverse)
      case head :: tail =>
        if(getCord(head,cord)<getCord(pivot,cord)) then split(tail,pivot,cord,head::minorsAcc,maxAcc)
        else split(tail,pivot,cord,minorsAcc,head::maxAcc)

    }

  def quickSortList(inputList: List[List[Int]], cord:Int): List[List[Int]] = inputList match {
      case Nil => Nil
      case pivot :: tail => val (minorsList, maxList) = split(tail, pivot, cord, Nil, Nil)
        appendTR(quickSortList(minorsList, cord), pivot :: quickSortList(maxList, cord))
  }
  
  def distanceTwoPoints(point1: List[Int], point2: List[Int]): Float = {
    val x = getCord(point1, 0) - getCord(point2, 0)
    val y = getCord(point1, 1) - getCord(point2, 1)
    (x * x) + (y * y)
  }
  @tailrec
  final def splitHalf(input:List[List[Int]], n: Int, acc: List[List[Int]]): (List[List[Int]],List[List[Int]]) = input match {
    case Nil => (acc.reverse,Nil)
    case head::tail=> if (n==0) (acc.reverse,input)
    else  splitHalf(tail,n-1,head::acc)
    
  }
  @tailrec
  final def length(points: List[List[Int]], acc: Int): Int =
    points match {
      case Nil => acc
      case _ :: tail => length(tail, acc + 1)
    }

  @tailrec
  final def franjaFilter(points: List[List[Int]], midX: Int, d: Int, acc: List[List[Int]]): List[List[Int]] =
    points match {
      case Nil => acc.reverse
      case head :: tail =>
        val dx = getCord(head, 0) - midX
        if (dx * dx <= d) franjaFilter(tail, midX, d, head :: acc)
        else franjaFilter(tail, midX, d, acc)
    }
  def closestPair(points: List[List[Int]]): List[List[Int]] =
    points match {
      case point1 :: point2 :: Nil => List(point1, point2)//case for list 2 points
      case point1 :: point2 :: point3 :: Nil =>// case 3
        val pq = distanceTwoPoints(point1, point2)
        val pr = distanceTwoPoints(point1, point3)
        val qr = distanceTwoPoints(point2, point3)
        if (pq <= pr && pq <= qr) List(point1, point2)
        else if (pr <= qr) List(point1, point3)
        else List(point2, point3)//falta lo de la franja hacer, ademas comparar
    }
}