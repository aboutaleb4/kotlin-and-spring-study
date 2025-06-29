package com.example.kotlinplayground

import anotherpackage.topLevelInt2

const val topLevelInt = 5

fun exploreTopLevelVariables() {
    printlnInBlue("Explore Top Level Int In Current File")
    println("topLevelInt : $topLevelInt")
    println()

    printlnInBlue("Explore Top Level Variables From Other File")
    println("topLevelInt2 : $topLevelInt2")
    println()
}