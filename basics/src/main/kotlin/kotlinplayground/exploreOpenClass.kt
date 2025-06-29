package com.example.kotlinplayground

fun exploreOpenClass() {
    printlnInBlue("Explore Open Class")
    val inheritingClass = InheritingClass(1)
    println(inheritingClass.id)
    inheritingClass.speak()
    inheritingClass.overridableSpeak()
    inheritingClass.sayMyName()
    println()
    val openClass = OpenClass(1)

    openClass.speak()
    openClass.overridableSpeak()
    openClass.sayMyName()
    println()
}

open class OpenClass(id: Int) {
    open var name = "OpenClass"
    fun speak() {
        println("I am OpenClass")
    }

    open fun overridableSpeak() {
        println("I am the overridable speak")
    }

    fun sayMyName() {
        println("My name is $name")
    }
}

class InheritingClass(val id: Int) : OpenClass(id) {
    override var name = "InheritingClass"
    override fun overridableSpeak() {
        super.overridableSpeak()
        println("I am the override")
    }
}