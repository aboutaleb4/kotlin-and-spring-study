package kotlinplayground

fun exploreCollectionsAndFilters() {
    printlnInBlue("Explore Collections And Filters")
    val collectionToExplore = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filteredCollection = collectionToExplore.filter { it % 3 == 0 }
    println(filteredCollection)
    println()
}