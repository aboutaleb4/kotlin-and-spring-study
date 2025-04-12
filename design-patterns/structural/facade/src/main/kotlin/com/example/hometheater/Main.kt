package com.example.hometheater

fun main() {
    // Create the subsystem components
    val dvdPlayer = DVDPlayer()
    val amplifier = Amplifier()
    val projector = Projector()
    val lights = Lights()
    val screen = Screen()
    val popcornMaker = PopcornMaker()

    // Create the facade
    val homeTheater = HomeTheaterFacade(
        dvdPlayer = dvdPlayer,
        amplifier = amplifier,
        projector = projector,
        lights = lights,
        screen = screen,
        popcornMaker = popcornMaker
    )

    // Using the facade to watch a movie
    println("\n=== Starting Movie Night ===\n")
    homeTheater.watchMovie("The Lord of the Rings")
    
    println("\n=== Movie is Over ===\n")
    homeTheater.endMovie()
} 