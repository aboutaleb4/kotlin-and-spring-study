package com.some.implementer

import com.some.sdk.SomeInterface
import com.some.sdk.SomeRequest

class SomeImplementation: SomeInterface {
    override fun someMethod(someRequest: SomeRequest) {
        println("some implementation")
    }
}