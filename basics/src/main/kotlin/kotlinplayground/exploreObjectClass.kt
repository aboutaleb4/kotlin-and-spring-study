package com.kotlinplayground

object ObjectClass {
    var name = "Default Name"
    fun sayMyName() {
        println("My name is $name") //Similar to singleton classes
    }

    fun setNyName(name: String) {
        this.name = name
    }
}

fun exploreObjectClass() {
    println(">>>>> Explore Object Class")
    val obj1 = ObjectClass

    val obj2 = ObjectClass

    println("Obj1 name is ${obj1.name}")
    println("Obj2 name is ${obj2.name}")
    obj1.setNyName("Heisenberg")
    println("Obj1 is renamed to ${obj1.name}")
    println("Obj1 name became ${obj1.name}")
    println("Obj2 name became ${obj2.name}")


    println()
}
