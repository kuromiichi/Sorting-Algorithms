fun main() {
    // Test for 200 results
    val method = "bubble"
    val times = LongArray(73)
    val sizes = IntArray(73)
    var i = 0
    var size = 1000
    do {
        println("Sorting array using $method method (${i + 1}/73)")
        times[i] = getSortingTime(numberOfArrays = 5, sizeOfArrays = size, method = method)
        sizes[i] = size
        size = (size * 1.1).toInt()
        i++
    } while (size <= 1_000_000)
    /*
    for (size in 5000..1000_000 step 5000) {
        println("Sorting array using $method method (${i + 1}/200)")
        times[i] = getSortingTime(numberOfArrays = 5, sizeOfArrays = size, method = method)
        i++
    }
     */
    // Print out the results
    println("Calculation completed")
    println("--------------------")
    println("TIMES")
    for (elem in times) {
        println(elem)
    }
    println("--------------------")
    println("SIZES")
    for (elem in sizes) {
        println(elem)
    }
}