package com.some.sdk

interface SomeInterface {
    fun someMethod(someRequest: SomeRequest)

    fun anotherMethod(someRequest: SomeRequest) {
        println("another method changed again again")
    }

    fun againAnotherMethod() {
        println("again another method")
    }
}