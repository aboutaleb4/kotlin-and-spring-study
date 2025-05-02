package org.example

class ScopeFunctions {
    fun demonstrateScopeFunctions() {
        // 1. let example
        val letResult = "Hello".let {
            println("let: Original string is $it")
            it.length
        }
        println("let result: $letResult")
        
        // 2. run example
        val runResult = "Kotlin".run {
            println("run: Original string is $this")
            length
        }
        println("run result: $runResult")
        
        // 3. with example
        val withResult = with("Programming") {
            println("with: Original string is $this")
            length
        }
        println("with result: $withResult")
        
        // 4. apply example
        val applyResult = StringBuilder().apply {
            append("Hello")
            append(" ")
            append("World")
        }
        println("apply result: ${applyResult.toString()}")
        
        // 5. also example
        val alsoResult = "Kotlin".also {
            println("also: Original string is $it")
        }
        println("Also result: $alsoResult")
    }
} 