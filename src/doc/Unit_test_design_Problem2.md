# Diseño Casos de prueba Quicksort3

---

## 1. Visión General del Plan de Pruebas

El objetivo de esta suite de pruebas unitarias es verificar la correctitud funcional y el comportamiento en límites del algoritmo **3-Way QuickSort** (`QuickSort3`) y sus metodos auxiliares (`concatenate` y `partition3`).

Las pruebas se dividen en tres áreas clave:

1. **`concatenate`**: Concatenación correcta y preservación de orden entre listas finitas.
2. **`partition3`**: Partición exacta en tres vías ($< p$, $= p$, $> p$) en una sola pasada.
3. **`quicksort3`**: Ordenamiento completo en presencia de duplicados, casos límite y arreglos invertidos.

---

## 2. Especificación Detallada de Casos de Prueba

### Componente 1: Método Auxiliar `concatenate`

| ID Test    | Nombre del Test | Entrada 1 (`list1`) | Entrada 2 (`list2`) | Resultado Esperado | Tipo de Escenario / Propósito |
|------------| --- | --- | --- | --- | --- |
| **CON-01** | Dos listas vacías | `Nil` | `Nil` | `Nil` | **Caso Borde:** Verifica el comportamiento con ambas entradas nulas/vacías. |
| **CON-02** | Primera lista vacía | `Nil` | `List(1, 2, 3)` | `List(1, 2, 3)` | **Caso Borde:** Elemento neutro a la izquierda. |
| **CON-03** | Segunda lista vacía | `List(1, 2, 3)` | `Nil` | `List(1, 2, 3)` | **Caso Borde:** Elemento neutro a la derecha. |
| **CON-04** | Dos listas no vacías | `List(1, 2, 3)` | `List(4, 5, 6)` | `List(1, 2, 3, 4, 5, 6)` | **Caso General:** Preservación de la secuencia original al unir dos conjuntos. |

---

### Componente 2: Función de Partición de 3 Vías `partition3`

*Parámetros de prueba comunes:* `lesserAcc = Nil`, `equalAcc = Nil`, `greaterAcc = Nil`

| ID Test     | Nombre del Test | Entrada (`inputList`) | Pivote (`pivot`) | Resultado Esperado `(Lesser, Equal, Greater)` | Propósito del Test |
|-------------| --- | --- | --- | --- | --- |
| **PART-01** | Lista vacía | `Nil` | `5` | `(Nil, Nil, Nil)` | **Caso Borde:** Retorno de tupla con acumuladores vacíos. |
| **PART-02** | Separación general de 3 vías | `List(3, 7, 5, 1, 9, 5, 2)` | `5` | `(List(3, 1, 2), List(5, 5), List(7, 9))` | **Caso General:** Agrupación simultánea de elementos menores, iguales y mayores. |
| **PART-03** | Todos los elementos iguales al pivote | `List(5, 5, 5, 5)` | `5` | `(Nil, List(5, 5, 5, 5), Nil)` | **Caso Límite:** Aislar elementos duplicados masivos en la partición central. |
| **PART-04** | Sin elementos iguales al pivote | `List(1, 8, 2, 9)` | `5` | `(List(1, 2), Nil, List(8, 9))` | **Caso Alternativo:** Manejo de lista sin coincidencias con el valor del pivote. |

---

### Componente 3: Algoritmo Principal `quicksort3`

| ID Test    | Nombre del Test | Entrada (`inputList`) | Resultado Esperado | Tipo de Escenario / Propósito                                                      |
|------------| --- | --- | --- |------------------------------------------------------------------------------------|
| **QS3-01** | Lista vacía | `Nil` | `Nil` | **Caso Borde:** Estabilidad con lista vacía.                                       |
| **QS3-02** | Lista de un elemento | `List(42)` | `List(42)` | **Caso Borde:** Elemento único (retorno directo sin partición).                    |
| **QS3-03** | Lista ya ordenada | `List(1, 2, 3, 4, 5)` | `List(1, 2, 3, 4, 5)` | **Caso Peor/Especial:** Comprobación de estabilidad en conjuntos pre-ordenados.    |
| **QS3-04** | Lista en orden inverso | `List(5, 4, 3, 2, 1)` | `List(1, 2, 3, 4, 5)` | **Caso Peor:** Verificación de correctitud al invertir completamente la secuencia. |
| **QS3-05** | Lista con elementos repetidos | `List(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)` | `List(1, 1, 2, 3, 3, 4, 5, 5, 6, 9)` | **Caso General:** Ordenamiento correcto preservando valores duplicados.            |
| **QS3-06** | Muchos valores iguales al pivote | `List(5, 5, 5, 5, 5)` | `List(5, 5, 5, 5, 5)` | **Caso Objetivo de 3-Way:** Eficiencia y estabilidad ante colecciones idénticas.   |
| **QS3-07** | Duplicados masivos mezclados | `List(4, 4, 2, 4, 1, 4, 3, 4)` | `List(1, 2, 3, 4, 4, 4, 4, 4)` | **Caso Objetivo de 3-Way:** Isolamiento eficiente del valor más frecuente.         |

### Componente 4: Algoritmo Principal `quicksort3` con conjunto de datos grandes