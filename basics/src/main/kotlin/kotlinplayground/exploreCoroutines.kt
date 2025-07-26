package org.example.kotlinplayground

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun exploreCoroutines() { // This is a regular non-suspend function
    printlnInBlue("Explore Coroutines")
    GlobalScope.launch { // Launch a new coroutine
        println("Inside coroutine: Calling suspend function...")
        val data = fetchDataFromNetwork() // This can only be called inside a coroutine or suspend function
        println("Inside coroutine: Received: $data")
    }

    println("Main program continues immediately, not waiting for coroutine...")
    Thread.sleep(3000) // Keep JVM alive for coroutine to finish
    println()
}

suspend fun fetchDataFromNetwork(): String {
    // Imagine this takes time, like calling an external API
    delay(2000) // This is a suspend function from kotlinx.coroutines, it doesn't block the thread
    return "Data from network"
}