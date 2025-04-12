package com.example.hometheater

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HomeTheaterFacadeTest {
    @Test
    fun `test watch movie sequence`() {
        // Capture console output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // Create components
        val dvdPlayer = DVDPlayer()
        val amplifier = Amplifier()
        val projector = Projector()
        val lights = Lights()
        val screen = Screen()
        val popcornMaker = PopcornMaker()

        // Create facade
        val homeTheater = HomeTheaterFacade(
            dvdPlayer = dvdPlayer,
            amplifier = amplifier,
            projector = projector,
            lights = lights,
            screen = screen,
            popcornMaker = popcornMaker
        )

        // Test watch movie
        homeTheater.watchMovie("The Matrix")

        // Get the output
        val output = outputStream.toString()

        // Verify the sequence of operations
        val expectedOperations = listOf(
            "Get ready to watch a movie...",
            "Popcorn maker is ON",
            "Making popcorn!",
            "Dimming lights to 10%",
            "Screen is coming down",
            "Projector is ON",
            "Projector in widescreen mode (16x9 aspect ratio)",
            "Amplifier is ON",
            "Setting DVD player as input",
            "Setting volume to 5",
            "DVD Player is ON",
            "Playing movie: The Matrix"
        )

        expectedOperations.forEach { operation ->
            assert(output.contains(operation)) { "Expected operation '$operation' not found in output" }
        }

        // Reset System.out
        System.setOut(System.out)
    }

    @Test
    fun `test end movie sequence`() {
        // Capture console output
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // Create components
        val dvdPlayer = DVDPlayer()
        val amplifier = Amplifier()
        val projector = Projector()
        val lights = Lights()
        val screen = Screen()
        val popcornMaker = PopcornMaker()

        // Create facade
        val homeTheater = HomeTheaterFacade(
            dvdPlayer = dvdPlayer,
            amplifier = amplifier,
            projector = projector,
            lights = lights,
            screen = screen,
            popcornMaker = popcornMaker
        )

        // Test end movie
        homeTheater.endMovie()

        // Get the output
        val output = outputStream.toString()

        // Verify the sequence of operations
        val expectedOperations = listOf(
            "Shutting down the home theater...",
            "Popcorn maker is OFF",
            "Lights at 100%",
            "Screen is going up",
            "Projector is OFF",
            "Amplifier is OFF",
            "DVD Player stopped",
            "DVD ejected",
            "DVD Player is OFF"
        )

        expectedOperations.forEach { operation ->
            assert(output.contains(operation)) { "Expected operation '$operation' not found in output" }
        }

        // Reset System.out
        System.setOut(System.out)
    }
} 