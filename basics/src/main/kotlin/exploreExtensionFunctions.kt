package org.example

import kotlinplayground.printlnInBlue

// Defining an extension Function
fun Int.minusFive(): Int = this - 5;

fun exploreExtensionFunctions() {
    printlnInBlue("Explore Extension Functions")
    val int = 5
    println(int.minusFive())
    println()
}