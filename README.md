# Sorting Algorithms

This Kotlin project aims to compare multiple sorting and searching algorithms and obtain information about how efficient they are as the array to be sorted or searched grows in size.

## Summary

The project generates a number of random integer arrays and compares the amount of nanoseconds it takes to sort them using _bubble sort_, _selection sort_, _insertion sort_, _shell sort_, and _quicksort_, or find an element in them using _linear search_, _iterative binary search_, and _recursive binary search_. The sorting algorithms are implemented in [`SortingAlgorithms.kt`](./src/main/kotlin/SortingAlgorithms.kt), the searching algorithms are in [`SearchAlgorithms.kt`](./src/main/kotlin/SearchAlgorithms.kt) and the algorithms to get the average time of five arrays with a specified size is coded in [`GetTime.kt`](./src/main/kotlin/GetTime.kt). The file [`Main.kt`](./src/main/kotlin/Main.kt) contains the code that prints the data to the console. This data is then used to create an Excel file and compare the differences in runtime.

## Data steps

Instead of using a linear step for the data, I'm using a geometrical step in order to obtain meaningful data, since the first couple of sort times are "very different", while the last ones are "similar", and it would take a lot of time to sort the largest arrays. This means that instead of adding 1000 elements to each array, I'm multiplying the number of elements by 1.1 in each iteration, reducing the total runtime.

## Excel document

The project contains an [Excel document](./SortingAlgorithms.xlsx) that shows the average times in the form of graphs. Each algorithm has its own graph, in addition to another couple of graphs that compare every algorithm, showing which one is the most efficient.

## Conclusion

Although every sorting algorithm sorts the arrays correctly, some of them do it _painfully slow_. Quicksort and Shell sort are by far the most efficient sorting methods, both of them managing to sort an array of almost one million elements in under 100 milliseconds. The rest of the methods became pretty slow once the numbers got bigger, and bubble sort _hasn't even finished_ sorting the last few arrays as I am writing this. Another notable result is that there is a great difference in how methods with different complexity handle larger arrays. Quicksort and shell sort times both increase linearly, while the rest increase exponentially. This makes the former algorithms the most efficient methods for sorting large arrays, while the latter are fine if the arrays are small (although quicksort and shell sort beat them in that situation too).

As for searching algorithms, binary search is clearly the winner compared to linear search, but I didn't find any clear runtime advantage using either the iterative version or the recursive version of the method. Both are really fast, and their differences might not be noticeable until arrays get a lot larger.