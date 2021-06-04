#Instrucciones

> Programa el algoritmo de conteo de inversiones y calcula con el número de inversiones en el arreglo de enteros de 
> “IntegerArray.txt”. Reporta tu código y resultado.

```
sort-and-count(L)
    if L has one element return 0
    else
        divide L into A, B
        (rA, A) = sort-and-count(A)
        (rb, B) = sort-and-count(B)
        (r, L) = merge-and-count(A, B)
    return r = rA + rB + r, L
```
```
merge-and-count(A, B)
    ;   A,B two input lists (sorted)
    ;   C output list
    ;   i,j current pointers to each list, start at beginning
    ;   a_i, b_j elements pointed by i, j
    ;   count number of inversion, initially 0
    
    while A,B != empty
        append min(a_i, b_j) to C
        if b_j < a_i
            count += number of element remaining in A
            j++
        else
            i++
    ;   now one list is empty
    append the remainder of the list to C
    return count, C    
```