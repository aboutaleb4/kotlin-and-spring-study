package com.kotlinplayground

fun exploreVisibilityModifier() {
    printlnInBlue("Explore Explore Visibility Modifier")
    val inheritedClassToTestVisibilityModifier = InheritedClassToTestVisibilityModifier()
    inheritedClassToTestVisibilityModifier.openFunction()
//    inheritedClassToTestVisibilityModifier.secretFunction()
//    inheritedClassToTestVisibilityModifier.protectedFunction()

    println()
}

open class OpenClassToTestVisibilityModifier {

    open fun openFunction() {
        println("Open Function")
    }

    private fun secretFunction() {
        println("Secret Function")
    }

    protected fun protectedFunction() {
        println("Protected Function")
    }
}

class InheritedClassToTestVisibilityModifier : OpenClassToTestVisibilityModifier() {
    override fun openFunction() {
        println("Inherit Function")
//        super.secretFunction()
        super.protectedFunction()
    }
}