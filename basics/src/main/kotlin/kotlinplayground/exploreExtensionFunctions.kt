package org.example.kotlinplayground

// Defining an extension Function
fun Int.minusFive(): Int = this - 5;

fun String.hasMinimumLength(minLength: Int): Boolean = this.length >= minLength

fun exploreExtensionFunctions() {
    printlnInBlue("Explore Extension Functions")
    val int = 5
    println(int.minusFive())
    println()

    println("Ahmed".hasMinimumLength(1))
    println("Ahmed".hasMinimumLength(6))

    println()
}