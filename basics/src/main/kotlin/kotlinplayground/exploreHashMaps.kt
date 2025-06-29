package org.example.kotlinplayground

fun exploreHashMaps() {
    printlnInBlue("Explore HashMaps")
    val mutableMap = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 3)
    mutableMap.forEach { key, value -> println("Key is $key, and value is $value") }
    println(mutableMap["key1"])
    println(mutableMap.getOrDefault("key1", 0))
    println(mutableMap[""])
    println(mutableMap.contains("key1"))
    println(mutableMap.contains("key4"))

    val filteredMap = mutableMap.filter { it.key != "key2" }.map { it.key.uppercase() }
    println("Filtered Map: $filteredMap")
    println()
}