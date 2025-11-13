package org.example

import org.example.kotlinplayground.exploreAccessModifiers
import org.example.kotlinplayground.exploreAnnotationsInKotlin
import org.example.kotlinplayground.exploreBreak
import org.example.kotlinplayground.exploreCheckingAndCasting
import org.example.kotlinplayground.exploreClassWithCompanionSection
import org.example.kotlinplayground.exploreConflictingInterfaceFunctions
import org.example.kotlinplayground.exploreCustomConstructorsAndInitFunctions
import org.example.kotlinplayground.exploreDataClass
import org.example.kotlinplayground.exploreDoWhile
import org.example.kotlinplayground.exploreFunctionsWithOptionalParams
import org.example.kotlinplayground.exploreInterfaces
import org.example.kotlinplayground.exploreLabel
import org.example.kotlinplayground.exploreMultipleConstructorsForClasses
import org.example.kotlinplayground.exploreObjectClass
import org.example.kotlinplayground.exploreOneLineFunctions
import org.example.kotlinplayground.exploreOpenClass
import org.example.kotlinplayground.exploreTopLevelVariables
import org.example.kotlinplayground.exploreVariables
import org.example.kotlinplayground.exploreVisibilityModifier
import org.example.kotlinplayground.exploreWhile
import org.example.kotlinplayground.exploreLambdaExpressions
import org.example.kotlinplayground.exploreNullableType
import org.example.kotlinplayground.exploreCollectionsAndFilters
import org.example.kotlinplayground.exploreExtensionFunctions
import org.example.kotlinplayground.exploreHashMaps
import org.example.kotlinplayground.exploreSequences
import org.example.kotlinplayground.exploreCollectionsNullablility
import org.example.kotlinplayground.exploreCoroutines
import org.example.kotlinplayground.exploreLibraries
import org.example.kotlinplayground.exploreScopeFunctions

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

    val number: Int? = null
    val x = numberOps.processNullableNumber(number)
    println(x)

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
    exploreExtensionFunctions()
    exploreHashMaps()
    exploreSequences()
    exploreCollectionsNullablility()
    exploreScopeFunctions()
    exploreCoroutines()
    exploreLibraries()
}

