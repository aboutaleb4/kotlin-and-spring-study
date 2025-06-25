package com.kotlinplayground

fun exploreLambdaExpressions() {
    printlnInBlue("Explore Lambda Expressions")
    val addLambda = {x: Int, y: Int -> x + y}
    println(addLambda(1, 6))
    println()
}