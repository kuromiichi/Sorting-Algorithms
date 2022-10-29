/**
 * Método de ordenación de burbuja
 * @param array: IntArray
 */
fun bubbleSort(array: IntArray) {
    // Variable auxiliar para intercambio de variables
    var aux: Int
    // Bucle externo
    for (i in 0 until array.size - 1) {
        // Bucle interno
        for (j in 0 until array.size - 1) {
            // Si el elemento siguiente es mayor, se intercambian
            if (array[j] > array[j + 1]) {
                aux = array[j]
                array[j] = array[j + 1]
                array[j + 1] = aux
            }
        }
    }
}

/**
 * Método de ordenación por selección
 * @param array: IntArray
 */
fun selectionSort(array: IntArray) {
    // Variable auxiliar para intercambio de variables y valor mínimo
    var aux: Int
    var min: Int
    // Bucle externo
    for (i in array.indices) {
        // Bucle interno
        min = i
        for (j in i + 1 until array.size) {
            // Si el elemento actual es menor que el mínimo, se actualiza el mínimo
            if (array[j] < array[min]) {
                min = j
            }
        }
        // Se intercambia el mínimo por el elemento correspondiente
        aux = array[i]
        array[i] = array[min]
        array[min] = aux
    }
}

/**
 * Método de ordenación por inserción
 * @param array: IntArray
 */
fun insertionSort(array: IntArray) {
    // Variable auxiliar para intercambio de variables y variable de comparación
    var aux: Int
    var j: Int
    // Bucle externo
    for (i in 1 until array.size) {
        // Se guarda el valor de la posición inicial
        aux = array[i]
        j = i - 1
        // Se compara hasta encontrar la posición del elemento
        while (j >= 0 && array[j] > aux) {
            // Se mueve el valor anterior a la posición siguiente
            array[j + 1] = array[j]
            j--
        }
        // Se asigna el valor del elemento a la posición correspondiente
        array[j + 1] = aux
    }
}

/**
 * Método Shell
 * @param array: IntArray
 */
fun shellSort(array: IntArray) {
    // Variables
    var aux:Int
    var j: Int
    var interval = 1
    // Comprobar tamaño máximo de intervalo
    while (interval < array.size) {
        interval = interval * 3 + 1
    }
    // Bucle externo
    while (interval > 0) {
        // Bucle interno
        for (i in interval until array.size) {
            // Se guarda el valor de la posición original
            aux = array[i]
            j = i
            // Bucle de inserción
            while (j > interval - 1 && array[j - interval] >= aux) {
                array[j] = array[j - interval]
                j -= interval
            }
            // Se coloca el valor original en la posición correspondiente
            array[j] = aux
        }
        // Reducir intervalo
        interval = (interval - 1) / 3
    }
}

/**
 * Método Quicksort
 * @param array: IntArray
 */
fun quickSort(array: IntArray) {
    qs(array, 0, array.size - 1)
}

/**
 * Método para encontrar el pivote para quicksort
 * @param array: IntArray
 * @param left: Int
 * @param right: Int
 */
fun pivot(array: IntArray, left: Int, right: Int): Int {
    // Crear variables para encontrar el pivote
    var i = left
    var j = right
    val pivot = array[left]
    // Bucle externo
    while (i < j) {
        // Avanzar por la izquierda
        while (array[i] <= pivot && i < j) {
            i++
        }
        // Avanzar por la derecha
        while (array[j] > pivot) {
            j--
        }
        // Cambiar elementos de la izquierda y la derecha
        if (i < j) {
            val aux = array[i]
            array[i] = array[j]
            array[j] = aux
        }
    }
    // Cambiar elemento final por pivote
    array[left] = array[j]
    array[j] = pivot
    return j
}

/**
 * Quicksort
 * @param array: IntArray
 * @param left: Int
 * @param right: Int
 */
fun qs(array: IntArray, left: Int, right: Int) {
    val piv: Int
    if (left < right) {
        // Elegir pivote
        piv = pivot(array, left, right)
        // Hacer quicksort a ambos lados del pivote
        qs(array, left, piv - 1)
        qs(array, piv + 1, right)
    }
}

