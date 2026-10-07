class QuickSortSuite extends munit.FunSuite {

  val qs = new QuickSort

  test("menores: lista vacía retorna Nil") {
    assertEquals(qs.smaller(Nil, 5), Nil)
  }

  test("menores: filtra correctamente los elementos menores al pivote") {
    assertEquals(qs.smaller(List(3, 7, 1, 9, 2), 5), List(3, 1, 2))
  }

  test("menores: ningún elemento es menor al pivote") {
    assertEquals(qs.smaller(List(5, 6, 7), 5), Nil)
  }

  test("menores: todos los elementos son menores al pivote") {
    assertEquals(qs.smaller(List(1, 2, 3), 5), List(1, 2, 3))
  }

  test("mayores: lista vacía retorna Nil") {
    assertEquals(qs.higher(Nil, 5), Nil)
  }

  test("mayores: filtra correctamente los elementos mayores o iguales al pivote") {
    assertEquals(qs.higher(List(3, 7, 1, 9, 2), 5), List(7, 9))
  }

  test("mayores: conserva los duplicados iguales al pivote") {
    assertEquals(qs.higher(List(5, 3, 5, 8, 5), 5), List(5, 5, 8, 5))
  }

  test("mayores: ningún elemento es mayor o igual al pivote") {
    assertEquals(qs.higher(List(1, 2, 3), 5), Nil)
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
    assertEquals(qs.separate(Nil, 5, Nil, Nil), (Nil, Nil))
  }

  test("separar: separa correctamente menores y mayores/iguales en un solo recorrido") {
    assertEquals(qs.separate(List(3, 7, 1, 9, 2), 5, Nil, Nil), (List(3, 1, 2), List(7, 9)))
  }

  test("separar: preserva el orden original de cada sublista") {
    assertEquals(qs.separate(List(8, 1, 6, 2, 9, 4), 5, Nil, Nil), (List(1, 2, 4), List(8, 6, 9)))
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
