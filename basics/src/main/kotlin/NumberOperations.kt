package org.example

class NumberOperations {
    // Extension function for Int
    fun Int.minusFive(): Int = this - 5

    // Function to demonstrate let usage with nullable numbers
    fun processNullableNumber(number: Int?): Int {
        return number?.let {
            val number2 = it + 1
            number2
        } ?: 4
    }
} 