class QuickSortSuite extends munit.FunSuite {

  val qs = new QuickSort

  test("menores: lista vacía retorna Nil") {
    assertEquals(qs.menores(Nil, 5), Nil)
  }

  test("menores: filtra correctamente los elementos menores al pivote") {
    assertEquals(qs.menores(List(3, 7, 1, 9, 2), 5), List(3, 1, 2))
  }

  test("menores: ningún elemento es menor al pivote") {
    assertEquals(qs.menores(List(5, 6, 7), 5), Nil)
  }

  test("menores: todos los elementos son menores al pivote") {
    assertEquals(qs.menores(List(1, 2, 3), 5), List(1, 2, 3))
  }

  test("mayores: lista vacía retorna Nil") {
    assertEquals(qs.mayores(Nil, 5), Nil)
  }

  test("mayores: filtra correctamente los elementos mayores o iguales al pivote") {
    assertEquals(qs.mayores(List(3, 7, 1, 9, 2), 5), List(7, 9))
  }

  test("mayores: conserva los duplicados iguales al pivote") {
    assertEquals(qs.mayores(List(5, 3, 5, 8, 5), 5), List(5, 5, 8, 5))
  }

  test("mayores: ningún elemento es mayor o igual al pivote") {
    assertEquals(qs.mayores(List(1, 2, 3), 5), Nil)
  }

  test("appendTR: concatenar dos listas vacías") {
    assertEquals(qs.appendTR(Nil, Nil), Nil)
  }

  test("appendTR: primera lista vacía") {
    assertEquals(qs.appendTR(Nil, List(1, 2, 3)), List(1, 2, 3))
  }

  test("appendTR: segunda lista vacía") {
    assertEquals(qs.appendTR(List(1, 2, 3), Nil), List(1, 2, 3))
  }

  test("appendTR: concatenar dos listas no vacías preservando el orden") {
    assertEquals(qs.appendTR(List(1, 2, 3), List(4, 5, 6)), List(1, 2, 3, 4, 5, 6))
  }

  test("separar: lista vacía retorna dos listas vacías") {
    assertEquals(qs.separar(Nil, 5, Nil, Nil), (Nil, Nil))
  }

  test("separar: separa correctamente menores y mayores/iguales en un solo recorrido") {
    assertEquals(qs.separar(List(3, 7, 1, 9, 2), 5, Nil, Nil), (List(3, 1, 2), List(7, 9)))
  }

  test("separar: preserva el orden original de cada sublista") {
    assertEquals(qs.separar(List(8, 1, 6, 2, 9, 4), 5, Nil, Nil), (List(1, 2, 4), List(8, 6, 9)))
  }


  test("quickSort: lista vacía") {
    assertEquals(qs.quickSort(Nil), Nil)
  }

  test("quickSort: lista de un elemento") {
    assertEquals(qs.quickSort(List(42)), List(42))
  }

  test("quickSort: lista ya ordenada") {
    assertEquals(qs.quickSort(List(1, 2, 3, 4, 5)), List(1, 2, 3, 4, 5))
  }

  test("quickSort: lista en orden inverso") {
    assertEquals(qs.quickSort(List(5, 4, 3, 2, 1)), List(1, 2, 3, 4, 5))
  }

  test("quickSort: lista con elementos repetidos") {
    assertEquals(qs.quickSort(List(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)), List(1, 1, 2, 3, 3, 4, 5, 5, 6, 9))
  }

  test("quickSort: lista con números negativos") {
    assertEquals(qs.quickSort(List(-3, 5, -1, 0, 2, -8)), List(-8, -3, -1, 0, 2, 5))
  }
}

class QuickSort3Suite extends munit.FunSuite {

  val qs3 = new QuickSort3
  test("concatenar: dos listas vacías") {
    assertEquals(qs3.concatenar(Nil, Nil), Nil)
  }

  test("concatenar: primera lista vacía") {
    assertEquals(qs3.concatenar(Nil, List(1, 2, 3)), List(1, 2, 3))
  }

  test("concatenar: segunda lista vacía") {
    assertEquals(qs3.concatenar(List(1, 2, 3), Nil), List(1, 2, 3))
  }

  test("concatenar: dos listas no vacías preservando el orden") {
    assertEquals(qs3.concatenar(List(1, 2, 3), List(4, 5, 6)), List(1, 2, 3, 4, 5, 6))
  }
  test("particionar: lista vacía retorna tres listas vacías") {
    assertEquals(qs3.particionar(Nil, 5), (Nil, Nil, Nil))
  }

  test("particionar: separa en menores, iguales y mayores en un solo recorrido") {
    assertEquals(
      qs3.particionar(List(3, 7, 5, 1, 9, 5, 2), 5),
      (List(3, 1, 2), List(5, 5), List(7, 9))
    )
  }

  test("particionar: todos los elementos son iguales al pivote") {
    assertEquals(qs3.particionar(List(5, 5, 5, 5), 5), (Nil, List(5, 5, 5, 5), Nil))
  }

  test("particionar: sin elementos iguales al pivote") {
    assertEquals(qs3.particionar(List(1, 8, 2, 9), 5), (List(1, 2), Nil, List(8, 9)))
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