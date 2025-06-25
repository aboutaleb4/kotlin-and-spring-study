package kotlinplayground

fun exploreAccessModifiers() {
    printlnInBlue("Explore Access Modifiers")
    val closedClassToTestAccessModifiers = ClosedClassToTestAccessModifiers()
    println("Accessing publicItem: ${closedClassToTestAccessModifiers.publicItem}")
    println("Accessing internalItem: ${closedClassToTestAccessModifiers.internalItem}")
    closedClassToTestAccessModifiers.accessItemsFromSubclass()
    println()
}

open class OpenClassToTestAccessModifiers {
    private val privateItem: Int = 1
    public val publicItem: Int = 1
    internal val internalItem: Int = 1
    protected val protectedItem: Int = 1
}

class ClosedClassToTestAccessModifiers: OpenClassToTestAccessModifiers() {
    fun accessItemsFromSubclass() {
        println("Accessing protectedItem from ClosedClass: $protectedItem")
        println("Accessing publicItem from ClosedClass: $publicItem")
        println("Accessing internalItem from ClosedClass: ${internalItem}")
    }
}