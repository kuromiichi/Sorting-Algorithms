/**
 * Método de búsqueda secuencial
 * @param array array en el que buscar
 * @param elemento elemento a buscar
 * @return el índice del elemento en el array, o -1 si no se encuentra
 */
fun linearSearch(array: IntArray, elemento: Int): Int {
    // Recorrer el array
    for (i in array.indices) {
        // Comprobar elemento
        if (array[i] == elemento) {
            // Devolver índice
            return i
        }
    }
    // Si no se encuentra se devuelve -1
    return -1
}

/**
 * Método de búsqueda binaria iterativa
 * @param array array en el que buscar
 * @param elemento elemento a buscar
 * @return el índice del elemento en el array, o -1 si no se encuentra
 */
fun iterativeBinarySearch(array: IntArray, elemento: Int): Int {
    var centro: Int
    var inf = 0
    var sup = array.size - 1
    // Bucle
    while (inf <= sup) {
        // Comprobar el elemento central del array
        centro = (sup + inf) / 2
        if (array[centro] == elemento) {
            // Devolver índice
            return centro
        // Partir el array a la mitad
        } else if (elemento < array[centro]) {
            sup = centro - 1
        } else {
            inf = centro + 1
        }
    }
    // Si no se encuentra se devuelve -1
    return -1
}

fun recursiveBinarySearch(array: IntArray, elemento: Int, inf: Int, sup: Int): Int {
    if (inf > sup) {
        // Si no se encuentra se devuelve -1
        return -1
    }
    // Comprobar el elemento central del array
    val centro = (sup + inf) / 2
    return if (array[centro] == elemento) {
        // Devolver índice
        centro
    // Partir el array a la mitad
    } else if (elemento < array[centro]) {
        recursiveBinarySearch(array, elemento, inf, centro - 1)
    } else {
        recursiveBinarySearch(array, elemento, centro - 1, sup)
    }
}