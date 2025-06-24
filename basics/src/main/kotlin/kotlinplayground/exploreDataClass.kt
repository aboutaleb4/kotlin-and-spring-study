package com.kotlinplayground

fun exploreDataClass() {
    printlnInBlue("Explore Data Class")
    println("**** Data Class ***")
    val sampleDataClass1 = SampleDataClass("Kotlin", 1)
    val sampleDataClass2 = SampleDataClass("Kotlin", 1)
    println(sampleDataClass1) // Data classes is useful here with logging.
    println(sampleDataClass1 == sampleDataClass2) //Data classes automatically implement equality checker.
    val sampleDataClass3 = sampleDataClass1.copy()
    println(sampleDataClass3)
    println(sampleDataClass1)
    val sampleDataClass4 = sampleDataClass1.copy(id = 21)
    println(sampleDataClass4)
    println(sampleDataClass1)
    println()

    println("**** Normal Class ***")
    val sampleNormalClass1 = SampleNormalClass("Kotlin", 1)
    val sampleNormalClass2 = SampleNormalClass("Kotlin", 1)
    println(sampleNormalClass1) // Normal classes don't have a print by default
    println(sampleNormalClass1 == sampleNormalClass2) //Data classes don't automatically implement equality checker.
    println()

}

data class SampleDataClass(val name: String, var id: Int)
class SampleNormalClass(val name: String, var id: Int)