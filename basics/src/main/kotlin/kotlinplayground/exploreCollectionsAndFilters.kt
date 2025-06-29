package kotlinplayground

fun exploreCollectionsAndFilters() {
    filterBasedOn { x: Int -> x % 3 == 0 }
}

private fun filterBasedOn(isDivisibleByThree: (Int) -> Boolean) {
    printlnInBlue("Explore Collections And Filters")

    val originalCollection = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Original Collection: $originalCollection")

    val filteredCollection = originalCollection.filter {
        isDivisibleByThree.invoke(it)
    }
    println("Filtered Collection: $filteredCollection")

    val mapped = originalCollection.map {
        it.toDouble()
    }
    println("Mapped Collection: $mapped")

    //Combining
    originalCollection.filter { isDivisibleByThree.invoke(it) }.map { it.toDouble() }.forEach(::println)
    println()

    val listOfLists = listOf(listOf(1, 2, 3), listOf(4, 5, 6))

    val mapRes = listOfLists.map { outerList -> outerList.map { it.toDouble() } }
    println("Mapped: $mapRes")
    val flatMapRes = listOfLists.flatMap { outerList -> outerList.map { it.toDouble() } }
    println("Mapped: $flatMapRes")

    println()
}