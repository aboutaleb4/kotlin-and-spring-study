package kotlinplayground

fun exploreCollectionsAndFilters() {
    filterBasedOn { x: Int -> x % 3 == 0 }
}

private fun filterBasedOn(isDivisibleByThree: (Int) -> Boolean) {
    printlnInBlue("Explore Collections And Filters")

    val originalCollection = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    print("Original Collection: ")
    println(originalCollection)

    val filteredCollection = originalCollection.filter {
        isDivisibleByThree.invoke(it)
    }
    print("Filtered Collection: ")
    println(filteredCollection)

    val mapped = originalCollection.map {
        it.toDouble()
    }
    print("Mapped Collection: ")
    println(mapped)

    println()
}