package kotlinplayground

fun exploreClassWithCompanionSection() {
    printlnInBlue("Explore ClassWith Companion Section")
    ClassWithCompanionSection.sayMyName()
    println(ClassWithCompanionSection.NAME)
    println()
}

class ClassWithCompanionSection {
    companion object {
        const val NAME = "ClassWithCompanionSection"
        fun sayMyName() {
            println("My name is $NAME")
        }
    }
}