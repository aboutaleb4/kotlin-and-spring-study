package kotlinplayground

fun exploreMultipleConstructorsForClasses() {
    printlnInBlue("Explore Multiple Constructors For Classes")
    val classWithEmptyDefaultAndSecondaryConstructors1 = ClassWithEmptyDefaultAndSecondaryConstructors(100)
    val classWithEmptyDefaultAndSecondaryConstructors2 = ClassWithEmptyDefaultAndSecondaryConstructors()
    println(classWithEmptyDefaultAndSecondaryConstructors1.age)
    println(classWithEmptyDefaultAndSecondaryConstructors2.age)
    println()
}

class ClassWithEmptyDefaultAndSecondaryConstructors() {
    var age: Int = 0

    constructor(_age: Int): this() {
        age = _age
    }
}