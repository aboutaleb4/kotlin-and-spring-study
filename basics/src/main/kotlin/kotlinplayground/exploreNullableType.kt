package com.example.kotlinplayground

fun exploreNullableType() {
    printlnInBlue("Explore Nullable Type")
    val nullableValue: String? = null
//    var nonNullableValue: String = null
    var nonNullableValue: String = "string"
    println(nullableValue?.length)
    println(nonNullableValue.length)

    val nullableValue2: String? = "passes"

    val nullableValue3: String? = null
    try {
        printStringThatIsNotNullable(nullableValue3!!)
    }
    catch (e: NullPointerException) {
        printStringThatIsNotNullable(e.javaClass.name)
    }

    nullableValue2?.let { printStringThatIsNotNullable(it) }
    nullableValue2?.run { printStringThatIsNotNullable(this) }
    printStringThatIsNotNullable(nullableValue2!!)
    nullableValue3?.let { printStringThatIsNotNullable(it) }
    nullableValue3?.run { printStringThatIsNotNullable(this) }
    println()
}

fun printStringThatIsNotNullable(string: String) {
    println(string)
}