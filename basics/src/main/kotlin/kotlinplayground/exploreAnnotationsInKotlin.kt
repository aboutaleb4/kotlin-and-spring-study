package com.example.kotlinplayground

import com.javaannotation.SimpleJavaAnnotation

fun exploreAnnotationsInKotlin() {
    printlnInBlue("Explore UsingAnnotations In Kotlin: ")
    @SimpleJavaAnnotation("Custom Value Here")
    class MyKotlinClassA {

    }

    // Apply the Java annotation to another class, using its default value
    @SimpleJavaAnnotation
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


    println()
}