/**
 * Creates an array containing a determined number of random numbers from zero to size.
 * @param size the number of random numbers
 * @return the created array
 * @throws IllegalArgumentException if the size of the array is zero or negative
 */
fun getArray(size: Int): IntArray {
    require(size >= 0) { "Size must be greater than zero" }
    return IntArray(size) { (0..size).random() }
}


/**
 * Calculates the arithmetic average of the elements of the array after removing the lowest and highest values.
 * @param times the array containing the elements to get the average from
 * @return the arithmetic average of the elements
 */
fun getAverageTime(times: LongArray): Long {
    times.sort()
    var sum = 0L
    for (i in 1 until times.size - 1) {
        sum += times[i]
    }
    return sum / (times.size - 2)
}

// Sorting functions

/**
 * Creates an array with the average time it takes to sort an array using a specified method.
 * @param numberOfArrays the number of arrays to sort
 * @param sizeOfArrays the size of each array
 * @param method the method to sort the array ("bubble", "selection", "insertion", "shell" or "quick")
 * @return the average time it takes to sort an array of the specified size
 * @throws IllegalArgumentException if the number or size of arrays is zero or less, or if the specified method doesn't appear in the list
 */
fun getSortingTime(numberOfArrays: Int = 5, sizeOfArrays: Int, method: String): Long {
    require(numberOfArrays > 0) { "Number of arrays must be greater than zero" }
    require(sizeOfArrays > 0) { "Number of arrays must be greater than zero" }
    require(
        method == "bubble"
                || method == "selection"
                || method == "insertion"
                || method == "shell"
                || method == "quick"
    ) { "Invalid sorting method" }

    // Array containing times of each sort
    val timeArray = LongArray(numberOfArrays)

    // Method selection
    for (i in timeArray.indices) {
        timeArray[i] = when (method) {
            "bubble" -> getBubbleTime(sizeOfArrays)
            "selection" -> getSelectionTime(sizeOfArrays)
            "insertion" -> getInsertionTime(sizeOfArrays)
            "shell" -> getShellTime(sizeOfArrays)
            "quick" -> getQuickTime(sizeOfArrays)
            // "else" statement is never reached since the method parameter is already validated
            else -> -1
        }
    }

    // Get average time
    return getAverageTime(timeArray)
}

/**
 * Creates an array of the given size and sorts it using bubble sort.
 * @param size the size of the array
 * @return the time it took to sort the array
 */
fun getBubbleTime(size: Int): Long {
    val array = getArray(size)
    val startTime = System.nanoTime()
    bubbleSort(array)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and sorts it using selection sort.
 * @param size the size of the array
 * @return the time it took to sort the array
 */
fun getSelectionTime(size: Int): Long {
    val array = getArray(size)
    val startTime = System.nanoTime()
    selectionSort(array)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and sorts it using insertion sort.
 * @param size the size of the array
 * @return the time it took to sort the array
 */
fun getInsertionTime(size: Int): Long {
    val array = getArray(size)
    val startTime = System.nanoTime()
    insertionSort(array)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and sorts it using shell sort.
 * @param size the size of the array
 * @return the time it took to sort the array
 */
fun getShellTime(size: Int): Long {
    val array = getArray(size)
    val startTime = System.nanoTime()
    shellSort(array)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and sorts it using quicksort.
 * @param size the size of the array
 * @return the time it took to sort the array
 */
fun getQuickTime(size: Int): Long {
    val array = getArray(size)
    val startTime = System.nanoTime()
    quickSort(array)
    return System.nanoTime() - startTime
}

// Search functions

/**
 * Creates an array with the average time it takes to find an element in an array using a specified method.
 * @param numberOfArrays the number of arrays to sort
 * @param sizeOfArrays the size of each array
 * @param method the method to search the array ("linear", "iterative" or "recursive")
 * @return the average time it takes to find an element in an array of the specified size
 * @throws IllegalArgumentException if the number or size of arrays is zero or less, or if the specified method doesn't appear in the list
 */
fun getSearchTime(numberOfArrays: Int = 5, sizeOfArrays: Int, method: String): Long {
    require(numberOfArrays > 0) { "Number of arrays must be greater than zero" }
    require(sizeOfArrays > 0) { "Number of arrays must be greater than zero" }
    require(
        method == "linear"
                || method == "iterative"
                || method == "recursive"
    ) { "Invalid search method" }

    // Array containing times of each search
    val timeArray = LongArray(numberOfArrays)

    // Method selection
    for (i in timeArray.indices) {
        timeArray[i] = when (method) {
            "linear" -> getLinearTime(sizeOfArrays)
            "iterative" -> getIterativeBinaryTime(sizeOfArrays)
            "recursive" -> getRecursiveBinaryTime(sizeOfArrays)
            // "else" statement is never reached since the method parameter is already validated
            else -> -1
        }
    }

    // Get average time
    return getAverageTime(timeArray)
}

/**
 * Creates an array of the given size and finds a random element in the array using linear search.
 * @param size the size of the array
 * @return the time it took to find the element
 */
fun getLinearTime(size: Int): Long {
    val array = getArray(size)
    val element = array.random()
    val startTime = System.nanoTime()
    linearSearch(array, element)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and finds a random element in the array using iterative binary search.
 * @param size the size of the array
 * @return the time it took to find the element
 */
fun getIterativeBinaryTime(size: Int): Long {
    val array = getArray(size)
    val element = array.random()
    val startTime = System.nanoTime()
    iterativeBinarySearch(array, element)
    return System.nanoTime() - startTime
}

/**
 * Creates an array of the given size and finds a random element in the array using recursive binary search.
 * @param size the size of the array
 * @return the time it took to find the element
 */
fun getRecursiveBinaryTime(size: Int): Long {
    val array = getArray(size)
    val element = array.random()
    val startTime = System.nanoTime()
    recursiveBinarySearch(array, element, 0, array.size - 1)
    return System.nanoTime() - startTime
}
