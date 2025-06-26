package kotlinplayground

fun exploreCollectionsAndFilters() {
    FilterBasedOn { x: Int -> x % 3 == 0 }
}

private fun FilterBasedOn(isDivisibleByThree: (Int) -> Boolean) {
    printlnInBlue("Explore Collections And Filters")
    val collectionToExplore = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filteredCollection = collectionToExplore.filter {
        isDivisibleByThree.invoke(it)
    }
    println(filteredCollection)
    println()
}