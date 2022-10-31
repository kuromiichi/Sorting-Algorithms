# Sorting Algorithms

This Kotlin project aims to compare multiple sorting algorithms and obtain information about how efficient they are as the array to be sorted grows in size.

## Summary

The project compares the amount of nanoseconds it takes to sort arrays using _bubble sort_, _selection sort_, _insertion sort_, _shell sort_, and _quicksort_. The sorting algorithms are implemented in `SortingAlgorithms.kt`, and the algorithms to get the average of five arrays with a specified size is coded in `GetTime.kt`. The file `Main.kt` contains the code that prints the data, using that data to create an Excel file and compare graphs.

## Data steps

Instead of using a linear step for the data, I'm using a geometrical step in order to obtain useful data, since the first couple of sort times are very different, while the last ones are similar, and it would take a lot of time to sort the biggest arrays. This means, instead of adding 1000 elements to each array, I'm multiplying the element number by 1.1, reducing the total runtime.

## Excel document

The project contains an Excel document that shows the average times in the form of graphs. Each sorting algorithm has its own graph, in addition to another graph that compares every algorithm, showing which one is the most efficient.
