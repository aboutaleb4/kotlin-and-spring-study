package kotlinplayground

fun exploreCheckingAndCasting() {
    printlnInBlue("Explore Checking And Casting")
    println("a" as String)
    println("a" is String)
    checker("string")
    checker(RandomClassToTestChecksAndCasts())
    println()


}

fun checker (any: Any) {
    when (any) {
        is String -> {
            println("I am a String")
        }
        is RandomClassToTestChecksAndCasts -> {
            println("I am a RandomClassToTestChecksAndCasts")
        }
        else -> println("I not any of those")

    }
}

class RandomClassToTestChecksAndCasts