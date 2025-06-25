package org.example

import kotlinplayground.exploreAccessModifiers
import kotlinplayground.exploreAnnotationsInKotlin
import kotlinplayground.exploreBreak
import kotlinplayground.exploreCheckingAndCasting
import kotlinplayground.exploreClassWithCompanionSection
import kotlinplayground.exploreConflictingInterfaceFunctions
import kotlinplayground.exploreCustomConstructorsAndInitFunctions
import kotlinplayground.exploreDataClass
import kotlinplayground.exploreDoWhile
import kotlinplayground.exploreFunctionsWithOptionalParams
import kotlinplayground.exploreInterfaces
import kotlinplayground.exploreLabel
import kotlinplayground.exploreMultipleConstructorsForClasses
import kotlinplayground.exploreObjectClass
import kotlinplayground.exploreOneLineFunctions
import kotlinplayground.exploreOpenClass
import kotlinplayground.exploreTopLevelVariables
import kotlinplayground.exploreVariables
import kotlinplayground.exploreVisibilityModifier
import kotlinplayground.exploreWhile
import kotlinplayground.exploreLambdaExpressions
import kotlinplayground.exploreNullableType
import kotlinplayground.exploreCollectionsAndFilters

// Defining an extension Function
fun Int.minusFive(): Int = this - 5;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, $name!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
    
    // Using NumberOperations class
    val numberOps = NumberOperations()
    val int = 5
    println(int.minusFive())
    
    var number: Int? = null
    val x = numberOps.processNullableNumber(number)
    println(x)

    // Using scope functions
    println("\nScope Functions Examples:")
    ScopeFunctions().demonstrateScopeFunctions()

    exploreVariables()
    exploreWhile()
    exploreDoWhile()
    exploreBreak()
    exploreLabel()
    exploreLabel()
    exploreOneLineFunctions()
    exploreConflictingInterfaceFunctions()
    exploreInterfaces()
    exploreOpenClass()
    exploreFunctionsWithOptionalParams()
    exploreClassWithCompanionSection()
    exploreAccessModifiers()
    exploreTopLevelVariables()
    exploreMultipleConstructorsForClasses()
    exploreAnnotationsInKotlin()
    exploreObjectClass()
    exploreDataClass()
    exploreCustomConstructorsAndInitFunctions()
    exploreVisibilityModifier()
    exploreCheckingAndCasting()
    exploreNullableType()
    exploreLambdaExpressions()
    exploreCollectionsAndFilters()
}

