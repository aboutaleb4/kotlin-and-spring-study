package org.example.kotlinplayground

import com.javaannotation.SimpleJavaAnnotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class SimpleKotlinAnnotation(
    val value: String = "default Kotlin Annotation Value",
    val value2: Int = 0
)

fun exploreAnnotationsInKotlin() {
    printlnInBlue("Explore UsingAnnotations In Kotlin: ")
    @SimpleJavaAnnotation("Custom Value to Java Annotation Here")
    @SimpleKotlinAnnotation("Custom Value to Kotlin Annotation Here")
    class MyKotlinClassA {

    }

    // Apply the Java annotation to another class, using its default value
    @SimpleJavaAnnotation
    @SimpleKotlinAnnotation
    class MyKotlinClassB {

    }

//    val annotationA = MyKotlinClassA().getAnnotation(com.javaannotation.SimpleJavaAnnotation::class.java)
//    val annotationB = MyKotlinClassB().getAnnotation(com.javaannotation.SimpleJavaAnnotation::class.java)

    val annotationA = MyKotlinClassA::class.java.getAnnotation(SimpleJavaAnnotation::class.java)
    val annotationB = MyKotlinClassB::class.java.getAnnotation(SimpleJavaAnnotation::class.java)

    annotationA?.let {
        println("Value for MyKotlinClassA: ${it.value}")
    } ?: println("MyKotlinClassA does not have com.javaannotation.SimpleJavaAnnotation.")

    annotationB?.let {
        println("Value for MyKotlinClassB: ${it.value}")
    } ?: println("MyKotlinClassB does not have com.javaannotation.SimpleJavaAnnotation.")



    val annotationA2 = MyKotlinClassA::class.java.getAnnotation(SimpleKotlinAnnotation::class.java)
    val annotationB2 = MyKotlinClassB::class.java.getAnnotation(SimpleKotlinAnnotation::class.java)

    annotationA2?.let {
        println("Value for MyKotlinClassA: ${it.value}")
    } ?: println("MyKotlinClassA does not have com.javaannotation.SimpleJavaAnnotation.")

    annotationB2?.let {
        println("Value for MyKotlinClassB: ${it.value}")
    } ?: println("MyKotlinClassB does not have com.javaannotation.SimpleJavaAnnotation.")


    println()
}