package kotlinplayground


fun exploreCollectionsNullablility() {
    printlnInBlue("Explore Collections Nullability")
    val listOfStrings = listOf("1", null, "22");
    listOfStrings.map { println(it?.length) }
    println()
}