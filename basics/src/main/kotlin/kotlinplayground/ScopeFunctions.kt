package kotlinplayground

var number: Int? = null
fun exploreScopeFunctions() {
    // 1. let example
    var letResult = number.let {
        it?.plus(10) ?: 0
    }
    println("let result 1: $letResult\n")

    number = 5
    letResult = number.let {
        it?.plus(10) ?: 0
    }
    println("let result 2: $letResult\n")

    // 2. run example
    val runResult = "Kotlin".run {
        println("run: Original string is $this")
        length
    }
    println("run result: $runResult\n")

    // 3. with example
    val withResult = with("Programming") {
        println("with: Original string is $this")
        length
    }
    println("with result: $withResult\n")

    // 4. apply example
    val applyResult = StringBuilder().apply {
        append("Hello")
        append(" ")
        append("World")
    }
    println("apply result: $applyResult\n")

    // 5. also example
    val alsoResult = "Kotlin".also {
        println("also: Original string is $it")
    }
    println("Also result: $alsoResult\n")
}