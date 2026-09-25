import scala.annotation.tailrec

class QuickSort {

  def menores(inputList: List[Int], p: Int): List[Int] =
    inputList match {
      case Nil => Nil
      case h :: tail =>
        if (h < p) then
          h :: menores(tail, p)
        else
          menores(tail, p)
    }

  def mayores(inputList: List[Int], p: Int): List[Int] =
    inputList match {
      case Nil => Nil
      case h :: tail =>
        // Se usa >= para conservar elementos duplicados iguales al pivote
        if (h >= p) then
          h :: mayores(tail, p)
        else
          mayores(tail, p)
    }

  def appendTR(inputL1: List[Int], inputL2: List[Int]): List[Int] = {
    @tailrec
    def loop(l1: List[Int], acc: List[Int]): List[Int] = l1 match {
      case Nil => acc
      case head :: tail => loop(tail, head :: acc)
    }
    loop(loop(inputL1, Nil), inputL2)
  }

  @tailrec
  final def separar(inputList: List[Int], p: Int, menoresAcc: List[Int], mayoresAcc: List[Int]): (List[Int], List[Int]) =
    inputList match {
      case Nil => (menoresAcc.reverse, mayoresAcc.reverse)
      case head :: tail =>
        if (head < p)
          separar(tail, p, head :: menoresAcc, mayoresAcc)
        else
          separar(tail, p, menoresAcc, head :: mayoresAcc)
    }

  def quickSort(inputList: List[Int]): List[Int] =
    inputList match {
      case Nil => Nil
      case pivot :: tail =>
        val (menoresList, mayoresList) = separar(tail, pivot, Nil, Nil)
        appendTR(quickSort(menoresList), pivot :: quickSort(mayoresList))
    }
}