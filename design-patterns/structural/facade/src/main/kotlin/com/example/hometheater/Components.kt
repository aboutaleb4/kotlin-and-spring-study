package com.example.hometheater

class DVDPlayer {
    fun on() = println("DVD Player is ON")
    fun off() = println("DVD Player is OFF")
    fun play(movie: String) = println("Playing movie: $movie")
    fun stop() = println("DVD Player stopped")
    fun eject() = println("DVD ejected")
}

class Amplifier {
    fun on() = println("Amplifier is ON")
    fun off() = println("Amplifier is OFF")
    fun setVolume(level: Int) = println("Setting volume to $level")
    fun setDvd(dvd: DVDPlayer) = println("Setting DVD player as input")
}

class Projector {
    fun on() = println("Projector is ON")
    fun off() = println("Projector is OFF")
    fun setInput(dvd: DVDPlayer) = println("Setting input to DVD Player")
    fun wideScreenMode() = println("Projector in widescreen mode (16x9 aspect ratio)")
}

class Lights {
    fun dim(level: Int) = println("Dimming lights to $level%")
    fun brighten() = println("Lights at 100%")
}

class Screen {
    fun down() = println("Screen is coming down")
    fun up() = println("Screen is going up")
}

class PopcornMaker {
    fun on() = println("Popcorn maker is ON")
    fun off() = println("Popcorn maker is OFF")
    fun pop() = println("Making popcorn!")
} 