import scala.annotation.tailrec

class QuickSort {

  /**
   *
   * @param inputList
   * @param p
   * @return
   */
  def smaller(inputList: List[Int], p: Int): List[Int] = {
    inputList match {
      case Nil => Nil
      case h :: tail =>
        if (h < p) then
          h :: smaller(tail, p)
        else
          smaller(tail, p)
    }
  }
    /**
     *
     * @param inputList
     * @param p
     * @return
     */
  def higher(inputList: List[Int], p: Int): List[Int] =
    inputList match {
      case Nil => Nil
      case h :: tail =>
        if (h >= p) then
          h :: higher(tail, p)
        else
          higher(tail, p)
    }

    /**
     *
     * @param inputL1
     * @param inputL2
     * @return
     */
  def appendTR(inputL1: List[Int], inputL2: List[Int]): List[Int] = {
    @tailrec
    def loop(l1: List[Int], acc: List[Int]): List[Int] = l1 match {
      case Nil => acc
      case head :: tail => loop(tail, head :: acc)
    }
    loop(loop(inputL1, Nil), inputL2)
  }

    /**
     *
     * @param inputList
     * @param p
     * @param menoresAcc
     * @param mayoresAcc
     * @return
     */
  @tailrec
  final def separate(inputList: List[Int], p: Int, menoresAcc: List[Int], mayoresAcc: List[Int]): (List[Int], List[Int]) =
    inputList match {
      case Nil => (menoresAcc.reverse, mayoresAcc.reverse)
      case head :: tail =>
        if (head < p)
          separate(tail, p, head :: menoresAcc, mayoresAcc)
        else
          separate(tail, p, menoresAcc, head :: mayoresAcc)
    }

  /**
   *
   * @param inputList
   * @return
   */
  def quickSort(inputList: List[Int]): List[Int] =
    inputList match {
      case Nil => Nil
      case pivot :: tail =>
        val (menoresList, mayoresList) = separate(tail, pivot, Nil, Nil)
        appendTR(quickSort(menoresList), pivot :: quickSort(mayoresList))
    }
}