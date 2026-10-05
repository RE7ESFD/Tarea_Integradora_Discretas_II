class QuickSort3 {

  def concatenar(a: List[Int], b: List[Int]): List[Int] =
    a match {
      case Nil => b
      case head :: tail =>
        head :: concatenar(tail, b)
    }

  def particionar(lista: List[Int], pivote: Int): (List[Int], List[Int], List[Int]) =
    lista match {
      case Nil => (Nil, Nil, Nil)
      case head :: tail =>
        particionar(tail, pivote) match {
          case (menores, iguales, mayores) =>
            if (head < pivote)
              (head :: menores, iguales, mayores)
            else if (head == pivote)
              (menores, head :: iguales, mayores)
            else
              (menores, iguales, head :: mayores)
        }
    }

  def quicksort3(lista: List[Int]): List[Int] =
    lista match {
      case Nil => Nil
      case pivote :: resto =>
        particionar(resto, pivote) match {
          case (menores, iguales, mayores) =>
            val izquierda = quicksort3(menores)
            val centro = pivote :: iguales
            val derecha = quicksort3(mayores)

            concatenar(
              concatenar(izquierda, centro),
              derecha
            )
        }
    }

}