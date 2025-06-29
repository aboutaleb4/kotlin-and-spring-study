package org.example

import com.example.kotlinplayground.exploreAccessModifiers
import com.example.kotlinplayground.exploreAnnotationsInKotlin
import com.example.kotlinplayground.exploreBreak
import com.example.kotlinplayground.exploreCheckingAndCasting
import com.example.kotlinplayground.exploreClassWithCompanionSection
import com.example.kotlinplayground.exploreConflictingInterfaceFunctions
import com.example.kotlinplayground.exploreCustomConstructorsAndInitFunctions
import com.example.kotlinplayground.exploreDataClass
import com.example.kotlinplayground.exploreDoWhile
import com.example.kotlinplayground.exploreFunctionsWithOptionalParams
import com.example.kotlinplayground.exploreInterfaces
import com.example.kotlinplayground.exploreLabel
import com.example.kotlinplayground.exploreMultipleConstructorsForClasses
import com.example.kotlinplayground.exploreObjectClass
import com.example.kotlinplayground.exploreOneLineFunctions
import com.example.kotlinplayground.exploreOpenClass
import com.example.kotlinplayground.exploreTopLevelVariables
import com.example.kotlinplayground.exploreVariables
import com.example.kotlinplayground.exploreVisibilityModifier
import com.example.kotlinplayground.exploreWhile
import com.example.kotlinplayground.exploreLambdaExpressions
import com.example.kotlinplayground.exploreNullableType
import com.example.kotlinplayground.exploreCollectionsAndFilters
import com.example.kotlinplayground.exploreExtensionFunctions
import com.example.kotlinplayground.exploreHashMaps
import com.example.kotlinplayground.exploreSequences
import com.example.kotlinplayground.exploreCollectionsNullablility
import com.example.kotlinplayground.exploreScopeFunctions

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
}

