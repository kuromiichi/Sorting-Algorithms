fun main() {
    getData("sort", "quick")
}

private fun getData(type: String, method: String) {
    require(type == "sort" || type == "search") { "Type must be \"sort\" or \"search\"." }
    // Test for 200 results
    val times = LongArray(73)
    val sizes = IntArray(73)
    var i = 0
    var size = 1000
    do {
        println(type + "ing array using $method method (${i + 1}/73)")
        times[i] = when (type) {
            "sort" -> getSortingTime(numberOfArrays = 5, sizeOfArrays = size, method = method)
            "search" -> getSearchTime(numberOfArrays = 5, sizeOfArrays = size, method = method)
            else -> -1
        }
        sizes[i] = size
        size = (size * 1.1).toInt()
        i++
    } while (size <= 1_000_000)

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