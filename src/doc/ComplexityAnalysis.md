# Analisis de complejidad

---

## Problema 1

---

## Problema 2

### 1. Partition3:

Recorre la lista de $n-1$ elementos exactamente una vez haciendo comparaciones de tiempo constante $O(1)$ por cada elemento y una adicional de verificación.

Por tanto:

$$ T_{\text{partition3}}(n)=T_{\text{partition3}}(n-1)+\Theta(1) $$

Resolviendo:

$$ T_{\text{partition3}}(n)=\Theta(n) $$

Por lo tanto:

$$ T_{\text{partition3}}(n)=\Theta(n) $$

Además, reverse() se ejecuta sobre las tres listas al finalizar. En conjunto, siguen teniendo como máximo n elementos, así que continúa siendo:

$$Θ(n)$$

### 2. Concatenate:

El método realiza:

loop(loop(list1, Nil), list2)

El primer loop recorre list1 y el segundo loop recorre la lista resultante para construir la concatenación.

Si:

$l$ = tamaño de list1

$m$ = tamaño de list2

Y $m+l = n$

entonces:

$$ T_{\text{concatenate}}(l,m)=\Theta(l)+\Theta(l+m) $$

Por lo tanto:

$$ T_{\text{concatenate}}(l,m)=\Theta(2l+m) $$

y, eliminando la constante:

$$ T_{\text{concatenate}}(l,m)=\Theta(l+m) $$

$$ T_{\text{concatenate}}(l,m)=\Theta(n) $$

### 3. Quicksort 3:

Este es el método importante.

Para una entrada de tamaño n:

1. Se escoge el primer elemento como pivote.
2. partition3 divide los restantes en:
- menores
- iguales
- mayores

3. Se ordena recursivamente la parte menor.
4. Se ordena recursivamente la parte mayor.
5. Se concatenan las tres partes.

La partición cuesta:

$$ \Theta(n) $$

y las concatenaciones también pueden costar en conjunto:

$$ \Theta(n) $$

Por tanto, si después de particionar tenemos:

- k elementos menores,
- e elementos iguales,
- n-k-e elementos mayores,

la recurrencia general es:

$$ T(n)=T(k)+T(n-k-e)+\Theta(n) $$

con:

$$ k+e+(n-k-e)=n $$

Esta es la recurrencia que representa correctamente el algoritmo.

### 4. Mejor caso
En el mejor caso, el pivote divide la lista en dos sublistas de tamaño aproximadamente \(n/2\). Por lo tanto, la relación de recurrencia es:

$$ T(n)=2T(n/2)+cn $$

Comparando con la forma $(T(n)=aT(n/b)+cn^d)$, tenemos $(a=2)$, $(b=2)$ y $(d=1)$. 

Calculamos:

$$ b^d=2^1=2 $$

Como $(a=b^d)$, se aplica el segundo caso del método maestro:

$$ T(n)=\Omega(n^d\log n) $$ $$ T(n)=\Omega(n\log n) $$

Por lo tanto, la complejidad del algoritmo en el mejor caso es $\Omega(n\log n)$.

### 5. Peor Caso:

El peor caso ocurre cuando el pivote es siempre el menor o el mayor elemento.

Por ejemplo:

[1, 2, 3, 4, 5, 6, ...] o [6, 5, 4, 3, 2, 1, ...]

Si elegimos siempre el primer elemento como pivote, una de las partes queda vacía y la otra contiene n-1 elementos.

La recurrencia es:

$$ T(n)=T(0)+T(n-1)+\Theta(n) =  T(n-1)+\Theta(n) $$


Desarrollándola:

$$ T(n)=T(n-1)+cn $$ $$ T(n)=T(n-2)+c(n-1)+cn $$ $$ T(n)=T(n-3)+c(n-2)+c(n-1)+cn $$

Finalmente:

$$ T(n)=T(1)+c(2+3+\dots+n) $$

Sabemos que:

$$ 2+3+\dots+n=\frac{n(n+1)}2-1 $$

Por tanto:

$$ T(n)=\Theta(n^2) $$

Así:

$$ T(n)=O(n^2) $$

### 6. Caso Promedio:

En promedio, QuickSort suele producir particiones razonablemente balanceadas. Para este algoritmo:
$$ T_{\text{promedio}}(n)=\Theta(n\log n) $$

---

## Problema 3

