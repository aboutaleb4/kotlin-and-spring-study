package org.example.kotlinplayground

fun exploreCustomConstructorsAndInitFunctions() {
    printlnInBlue("Explore Custom Constructors and Init Functions")
    ClassWithInitFunction()
    println()
    val classWithInitFunctionCreatedWithAge = ClassWithInitFunction(100)
    println()
    val classWithInitFunctionCreatedWithName = ClassWithInitFunction("Ahmed")
    println()

    println(classWithInitFunctionCreatedWithAge.age)
    classWithInitFunctionCreatedWithAge.name // Custom getter prints
    println()

    try {
        classWithInitFunctionCreatedWithName.name = "Default Name"
    } catch (e: Exception) {
        println(e.message)
    }

    try {
        classWithInitFunctionCreatedWithName.name = "Heisenberg"
        print("Name was successfully set to ")
        classWithInitFunctionCreatedWithName.name //Custom getter prints
    } catch (e: Exception) {
        println(e.message)
    }
    println()
}

class ClassWithInitFunction(name: String = "Default Name") {
    var age: Int = 0
    var name: String = "Default Name"
        get(){
            println(field)
            return field
        }
        set(value) {
            if(value == "Default Name") {
                throw Exception("Can't set name to default value")
            }
            field = value
        }
    init {
        println("Init Function executed for name: $name")
        age = age - 5
        println("Age printed at the end of Init function: $age")
    }

    constructor(_age: Int): this() {
        age = _age
        println("Custom Constructor executed for age: $age")
    }
}