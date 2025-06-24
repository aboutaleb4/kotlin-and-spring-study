package com.kotlinplayground

fun exploreWhile() {
    printlnInBlue("Explore While")
    var counter = 0

    while (counter < 10) {
        println("Counter is $counter")
        counter++
    }
    println()
}

fun exploreDoWhile() {
    printlnInBlue("Explore Do While")
    var counter = 0
    do {
        println("Counter is $counter")
        counter++
    } while (counter < 10)
    println()
}