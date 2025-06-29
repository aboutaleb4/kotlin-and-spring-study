package kotlinplayground

fun exploreSequences() {
    /*
    * More efficient than normal collations.
    * Suitable for very big collections with many operations.
    * */
    printlnInBlue("Explore Sequences")
    val list = listOf(1, 2, 3, 4, 5, 6)
    val newList = list.asSequence().map { it * it }.toList()
    println(newList)
    println()
}