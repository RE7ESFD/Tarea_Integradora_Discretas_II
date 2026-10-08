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

  def quickSortList(inputList: List[List[Int]], cord:Int): List[List[Int]] =
    inputList match {
      case Nil => Nil
      case pivot :: tail => val (minorsList, maxList) = split(tail, pivot, cord, Nil,Nil)
        appendTR(quickSortList(minorsList,cord), pivot :: quickSortList(maxList,cord))
    }
   def calculateDistanceLessDistanceTwoPoints(tailX: List [List[Int]], tailY: List[List[Int]]): Float = {(tailX, tailY) match {


    }


}