class QuickSort3Suite extends munit.FunSuite {

  val qs3 = new QuickSort3
  test("concatenar: dos listas vacías") {
    assertEquals(qs3.concatenate(Nil, Nil), Nil)
  }

  test("concatenar: primera lista vacía") {
    assertEquals(qs3.concatenate(Nil, List(1, 2, 3)), List(1, 2, 3))
  }

  test("concatenar: segunda lista vacía") {
    assertEquals(qs3.concatenate(List(1, 2, 3), Nil), List(1, 2, 3))
  }

  test("concatenar: dos listas no vacías preservando el orden") {
    assertEquals(qs3.concatenate(List(1, 2, 3), List(4, 5, 6)), List(1, 2, 3, 4, 5, 6))
  }

  test("partition3: empty list returns empty accumulator tuples") {
    assertEquals(
      qs3.partition3(Nil, 5, Nil, Nil, Nil),
      (Nil, Nil, Nil)
    )
  }

  test("partition3: splits into lesser, equal, and greater in a single pass") {
    assertEquals(
      qs3.partition3(List(3, 7, 5, 1, 9, 5, 2), 5, Nil, Nil, Nil),
      (List(3, 1, 2), List(5, 5), List(7, 9))
    )
  }

  test("partition3: all elements equal to the pivot") {
    assertEquals(
      qs3.partition3(List(5, 5, 5, 5), 5, Nil, Nil, Nil),
      (Nil, List(5, 5, 5, 5), Nil)
    )
  }

  test("partition3: no elements equal to the pivot") {
    assertEquals(
      qs3.partition3(List(1, 8, 2, 9), 5, Nil, Nil, Nil),
      (List(1, 2), Nil, List(8, 9))
    )
  }
  test("quicksort3: lista vacía") {
    assertEquals(qs3.quicksort3(Nil), Nil)
  }

  test("quicksort3: lista de un elemento") {
    assertEquals(qs3.quicksort3(List(42)), List(42))
  }

  test("quicksort3: lista ya ordenada") {
    assertEquals(qs3.quicksort3(List(1, 2, 3, 4, 5)), List(1, 2, 3, 4, 5))
  }

  test("quicksort3: lista en orden inverso") {
    assertEquals(qs3.quicksort3(List(5, 4, 3, 2, 1)), List(1, 2, 3, 4, 5))
  }

  test("quicksort3: lista con elementos repetidos") {
    assertEquals(qs3.quicksort3(List(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)), List(1, 1, 2, 3, 3, 4, 5, 5, 6, 9))
  }

  test("quicksort3: muchos valores iguales al pivote") {
    assertEquals(qs3.quicksort3(List(5, 5, 5, 5, 5)), List(5, 5, 5, 5, 5))
  }

  test("quicksort3: lista con muchos duplicados mezclados con otros valores") {
    assertEquals(qs3.quicksort3(List(4, 4, 2, 4, 1, 4, 3, 4)), List(1, 2, 3, 4, 4, 4, 4, 4))
  }
}