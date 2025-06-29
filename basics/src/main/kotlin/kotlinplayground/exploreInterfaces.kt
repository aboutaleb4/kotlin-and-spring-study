package com.example.kotlinplayground

fun exploreInterfaces() {
    printlnInBlue("Explore Interfaces")
    val interfaceImpl = InterfaceImpl()
    println(interfaceImpl.methodInInterface())
    println()
}

interface Interface {
    var x: Int
    fun methodWithNoImpl(a: Int, b: Int): Int

    fun methodWithImpl(a: Int, b: Int): Int {
        return a + b
    }

    fun methodInInterface(): Int {
        return x + 10
    }
}

class InterfaceImpl: Interface {
    override var x: Int = 10
    override fun methodWithNoImpl(a: Int, b: Int): Int {
        return a - b
    }

    override fun methodWithImpl(a: Int, b: Int): Int {
        return a + b // I can override the method with Imp
    }
}