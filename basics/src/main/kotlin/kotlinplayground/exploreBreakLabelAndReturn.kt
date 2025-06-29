package org.example.kotlinplayground

fun exploreBreak() {
    printlnInBlue("Explore Break")
    for (i in 1..5) {
        if (i == 3) break
        println("i = $i")
    }
    println()
}

fun exploreLabel() {
    printlnInBlue("Explore Label")
    loop@ for (i in 1..5) {
        if (i == 3) break@loop
        println("i = $i")

        loop2@ for (j in 1..5) {
            if (j == 3) break@loop2
            println("j = $j")
        }
    }
    println()
}

