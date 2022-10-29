fun main() {
    val mult = 1000
    for (i in 10..1000 step 10) {
        println("${i * mult} elements: ${getSortingTime(5, i * mult, "shell") / 1000_000} ms")
    }
}