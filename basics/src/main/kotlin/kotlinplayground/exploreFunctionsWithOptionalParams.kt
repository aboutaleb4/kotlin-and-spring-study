package com.kotlinplayground

fun exploreFunctionsWithOptionalParams() {
    printlnInBlue("Explore Functions With Optional Params")
    functionWithOptionalParams("Ahmed", 2, surname = "Aboutaleb")
    println()
}

fun functionWithOptionalParams(name: String, age: Int, email: String = "a@b.com", surname: String = "Surname") {
    println("$name, $age, $email, $surname")
}