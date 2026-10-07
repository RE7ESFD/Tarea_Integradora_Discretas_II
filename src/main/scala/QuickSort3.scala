import scala.annotation.tailrec


class QuickSort3 {

  /**
   * Concatenates two lists using a tail-recursive helper function.
   *
   * @param list1 The first list to concatenate.
   * @param list2 The second list to concatenate.
   * @return A new list containing elements from list1 followed by list2.
   */
  def concatenate(list1: List[Int], list2: List[Int]): List[Int] = {
    @tailrec
    def loop(source: List[Int], acc: List[Int]): List[Int] = source match {
      case Nil => acc
      case head :: tail => loop(tail, head :: acc)
    }
    loop(loop(list1, Nil), list2)
  }

  /**
   * Partitions a list into three sublists based on a pivot value:
   * elements less than, equal to, and greater than the pivot.
   *
   * @param inputList The list to be partitioned.
   * @param pivot The pivot value used for comparison.
   * @param lesserAcc Accumulator for elements smaller than the pivot.
   * @param equalAcc Accumulator for elements equal to the pivot.
   * @param greaterAcc Accumulator for elements greater than the pivot.
   * @return A tuple containing (lesserElements, equalElements, greaterElements).
   */
    @tailrec
    final def partition3(
                          inputList: List[Int],
                          pivot: Int,
                          lesserAcc: List[Int],
                          equalAcc: List[Int],
                          greaterAcc: List[Int]
                        ): (List[Int], List[Int], List[Int]) =
      inputList match {
        case Nil => (lesserAcc.reverse, equalAcc.reverse, greaterAcc.reverse)
        case head :: tail =>
          if (head < pivot)
            partition3(tail, pivot, head :: lesserAcc, equalAcc, greaterAcc)
          else if (head == pivot)
            partition3(tail, pivot, lesserAcc, head :: equalAcc, greaterAcc)
          else
            partition3(tail, pivot, lesserAcc, equalAcc, head :: greaterAcc)
      }

  /**
   * Sorts a list of integers using the 3-way QuickSort algorithm.
   *
   * @param inputList The list of integers to sort.
   * @return A new sorted list of integers in ascending order.
   */
  def quicksort3(inputList: List[Int]): List[Int] =
    inputList match {
      case Nil => Nil
      case pivot :: tail =>
        val (lesser, equal, greater) = partition3(tail, pivot, Nil, List(pivot), Nil)
        val leftSorted = quicksort3(lesser)
        val rightSorted = quicksort3(greater)
        concatenate(concatenate(leftSorted, equal), rightSorted)
    }
}