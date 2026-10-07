# Inducción Estructural

---

## Problema 1

---

## Problema 2
### Demostración de Correctitud: partition3

Demostramos que para cualquier lista $L$, la función partition3(L, p, AL, AE, AG) 
separa correctamente los elementos menores, iguales y mayores que el pivote $p$.

#### 1. Caso Base: L=Nil (Lista vacía)
- Al pasar una lista vacía, el código retorna los acumuladores invertidos (AL.reverse, AE.reverse, AG.reverse). 
- Como la lista no tiene elementos, no hay nada nuevo que clasificar. El resultado es directamente el contenido previo de los acumuladores. Se cumple.
#### 2. Hipótesis Inductiva (H.I.)

Asumimos que partition3(T, p, AL, AE, AG) funciona correctamente para una lista cola $T$.
#### 3. Paso Inductivo: $L = h :: T$ (Lista con cabeza $h$ y cola $T$)
   
Evaluamos el comportamiento según el valor del elemento $h$:

- Si $h < p$: El algoritmo hace la llamada partition3(T, p, h :: AL, AE, AG). Por H.I., la función clasificará correctamente la cola $T$ agregando $h$ al acumulador de menores.


- Si $h = p$: El algoritmo hace la llamada partition3(T, p, AL, h :: AE, AG). Por H.I., la función clasificará correctamente la cola $T$ agregando $h$ al acumulador de iguales.


- Si $h > p$: El algoritmo hace la llamada partition3(T, p, AL, AE, h :: AG). Por H.I., la función clasificará correctamente la cola $T$ agregando $h$ al acumulador de mayores.

En los tres casos, la cabeza $h$ se coloca en el acumulador adecuado y el resto de la lista se procesa según la Hipótesis Inductiva. Se cumple.

#### Conclusión:
Por Inducción Estructural, la función partition3 es correcta para cualquier lista finita.

### Complejidad Quicksort3



---

## Problema 3