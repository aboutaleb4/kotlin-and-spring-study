package com.kotlinplayground

fun exploreLambdaExpressions() {
    printlnInBlue("Explore Lambda Expressions")
    val addLambda = {x: Int, y: Int -> x + y}
    println(addLambda(1, 6))
    calculateAndPrint(4, 5, addLambda)
    println()
}

fun calculateAndPrint(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    val output = op(x, y)
    println(output)
    return output
}