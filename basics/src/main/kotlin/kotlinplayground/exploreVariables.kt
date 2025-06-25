package kotlinplayground

fun exploreVariables() {

    printlnInBlue("Explore Variables")
    val x: Int
    x = 5
    println(x)

    val name = "Kotlin"

    println(name)

    println("This programming language is $name and it consists of ${name.length} letters.")

    val tripleQuotedString = """
        Ahmed
        Aboutaleb
    """.trimIndent()

    println(tripleQuotedString)

    var salary = 900L

    println(salary)

    val ifStatementsReturnValue = if (salary > 900) {
        "Big Salary"
    }
    else if (salary > 500) {
        "Medium Salary"
    }
    else {
        ""
    }

    println(ifStatementsReturnValue)

    salary = 90L

    val ifStatementsReturnValue2 = when {
        salary > 900 -> "Big Salary"
        salary > 500 -> "Medium Salary"
        else -> "Small Salary"
    }

    println(ifStatementsReturnValue2)

    println()
}

