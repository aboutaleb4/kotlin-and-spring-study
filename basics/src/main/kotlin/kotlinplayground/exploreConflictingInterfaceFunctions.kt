package com.example.kotlinplayground

fun exploreConflictingInterfaceFunctions() {
    printlnInBlue("Explore Conflicting Interface Functions")
    val implOfBothInterfaces = ImplOfBothInterfaces()
    implOfBothInterfaces.method()
    println()
}

interface FirstInterface {
    fun method(){
        println("method from FirstInterface")
    }
}

interface SecondInterface {
    fun method(){
        println("method from SecondInterface")
    }
}

class ImplOfBothInterfaces: FirstInterface, SecondInterface {
    override fun method() {
        super<FirstInterface>.method()
        super<SecondInterface>.method()
        println("method from ImplOfBothInterfaces")
    }
}