import scala.annotation.tailrec
import scala.util.Random


object Quicksort3Experiment {

  /**
   * Tail-recursive helper to generate a list of random integers.
   * @param size
   * @param maxValue
   * @return
   */
  def generateRandomList(size: Int, maxValue: Int): List[Int] = {
    val rng = new Random()
    @tailrec
    def loop(remaining: Int, acc: List[Int]): List[Int] = {
      if (remaining <= 0) acc
      else loop(remaining - 1, rng.nextInt(maxValue) :: acc)
    }
    loop(size, Nil)
  }

  /**
   * Tail-recursive helper to generate a list with repeated elements.
   * @param size
   * @param uniqueCount
   * @return
   */
  def generateRepeatedList(size: Int, uniqueCount: Int): List[Int] = {
    val rng = new Random()
    @tailrec
    def loop(remaining: Int, acc: List[Int]): List[Int] = {
      if (remaining <= 0) acc
      else loop(remaining - 1, rng.nextInt(uniqueCount) :: acc)
    }
    loop(size, Nil)
  }

  /**
   * Tail-recursive function to collect execution times across iterations.
   * Discards the first execution  and stores the rest in a list.
   * @param sorter
   * @param data
   * @param iterations
   * @return
   */
  def collectTimes(sorter: QuickSort3, data: List[Int], iterations: Int): List[Double] = {
    @tailrec
    def loop(currentStep: Int, accTimes: List[Double]): List[Double] = {
      if (currentStep >= iterations) accTimes
      else {
        val startTime = System.nanoTime()
        val _ = sorter.quicksort3(data)
        val endTime = System.nanoTime()
        val durationMs = (endTime - startTime) / 1e6

        if (currentStep == 0) loop(currentStep + 1, accTimes)
        else loop(currentStep + 1, durationMs :: accTimes)
      }
    }
    loop(0, Nil)
  }

  /**
   * Tail-recursive function to sum a list of double values.
   * @param list
   * @param acc
   * @return
   */
  @tailrec
  def sumList(list: List[Double], acc: Double): Double = list match {
    case Nil => acc
    case head :: tail => sumList(tail, acc + head)
  }

  /**
   * Tail-recursive function to calculate length of a double list.
   * @param list
   * @param acc
   * @return
   */
  @tailrec
  def lengthList(list: List[Double], acc: Int): Int = list match {
    case Nil => acc
    case _ :: tail => lengthList(tail, acc + 1)
  }

  /**
   * Computes average execution time by dividing tail-recursive sum by list length.
   * @param times
   * @return
   */
  def computeAverage(times: List[Double]): Double = {
    val totalSum = sumList(times, 0.0)
    val totalCount = lengthList(times, 0)
    if (totalCount == 0) 0.0 else totalSum / totalCount
  }

  /**
   * Tail-recursive helper to process and print scenarios sequentially
   * @param sorter
   * @param scenarios
   */
  @tailrec
  def runScenarios(
                    sorter: QuickSort3,
                    scenarios: List[(String, Int)]
                  ): Unit = scenarios match {
    case Nil => ()
    case (label, size) :: tail =>
      val randomData = generateRandomList(size, 100000)
      val repeatedData = generateRepeatedList(size, 5)

      val timesRandom = collectTimes(sorter, randomData, 10)
      val timesRepeated = collectTimes(sorter, repeatedData, 10)

      val avgRandom = computeAverage(timesRandom)
      val avgRepeated = computeAverage(timesRepeated)

      printf("%-28s | %-18.4f | %-18.4f%n", label, avgRandom, avgRepeated)
      runScenarios(sorter, tail)
  }

  def main(args: Array[String]): Unit = {
    val sorter = new QuickSort3()

    val scenarioList: List[(String, Int)] =
      ("Toy (n = 50)", 50) ::
        ("Small (n = 1,000)", 1000) ::
        ("Small (n = 5,000)", 5000) ::
        ("Medium (n = 40,000)", 40000) ::
        ("Medium (n = 80,000)", 80000) ::
        ("Large (n = 1,000,000)", 1000000) :: Nil

    println("--------------------------------------------------------------------")
    println("          RESULTS: QuickSort3 (3-Way Partition)           ")
    println("--------------------------------------------------------------------")
    printf("%-28s | %-18s | %-18s%n", "Scenario (Size)", "Random Data (ms)", "Repeated Data (ms)")
    println("--------------------------------------------------------------------")

    runScenarios(sorter, scenarioList)
  }
}