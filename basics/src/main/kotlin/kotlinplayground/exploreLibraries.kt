package org.example.kotlinplayground

import com.some.sdk.SomeInterface
import com.some.sdk.SomeRequest

fun exploreLibraries(someInterface: SomeInterface) {
    printlnInBlue("Exploring Libraries")
    someInterface.someMethod(SomeRequest())
    someInterface.anotherMethod(SomeRequest())
    someInterface.againAnotherMethod()
    println()
}