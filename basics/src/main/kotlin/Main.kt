package org.example

import com.kotlinplayground.exploreAccessModifiers
import com.kotlinplayground.exploreAnnotationsInKotlin
import com.kotlinplayground.exploreBreak
import com.kotlinplayground.exploreCheckingAndCasting
import com.kotlinplayground.exploreClassWithCompanionSection
import com.kotlinplayground.exploreConflictingInterfaceFunctions
import com.kotlinplayground.exploreCustomConstructorsAndInitFunctions
import com.kotlinplayground.exploreDataClass
import com.kotlinplayground.exploreDoWhile
import com.kotlinplayground.exploreFunctionsWithOptionalParams
import com.kotlinplayground.exploreInterfaces
import com.kotlinplayground.exploreLabel
import com.kotlinplayground.exploreMultipleConstructorsForClasses
import com.kotlinplayground.exploreObjectClass
import com.kotlinplayground.exploreOneLineFunctions
import com.kotlinplayground.exploreOpenClass
import com.kotlinplayground.exploreTopLevelVariables
import com.kotlinplayground.exploreVariables
import com.kotlinplayground.exploreVisibilityModifier
import com.kotlinplayground.exploreWhile
import com.kotlinplayground.exploreLambdaExpressions
import org.kotlinplayground.exploreNullableType

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
}

