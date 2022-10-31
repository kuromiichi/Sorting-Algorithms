fun main() {
    // Test for 200 results
    val method = ""
    val times = LongArray(200)
    var i = 0
    for (size in 5000..1000_000 step 5000) {
        println("Sorting array using $method method (${i + 1}/200)")
        times[i] = getSortingTime(numberOfArrays = 5, sizeOfArrays = size, method = method)
        i++
    }
    // Print out the results
    println("Calculation completed")
    for (elem in times) {
        println(elem)
    }
}