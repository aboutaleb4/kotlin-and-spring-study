package com.example.hometheater

class HomeTheaterFacade(
    private val dvdPlayer: DVDPlayer,
    private val amplifier: Amplifier,
    private val projector: Projector,
    private val lights: Lights,
    private val screen: Screen,
    private val popcornMaker: PopcornMaker
) {
    fun watchMovie(movie: String) {
        println("Get ready to watch a movie...")
        popcornMaker.on()
        popcornMaker.pop()
        lights.dim(10)
        screen.down()
        projector.on()
        projector.wideScreenMode()
        amplifier.on()
        amplifier.setDvd(dvdPlayer)
        amplifier.setVolume(5)
        dvdPlayer.on()
        dvdPlayer.play(movie)
    }

    fun endMovie() {
        println("Shutting down the home theater...")
        popcornMaker.off()
        lights.brighten()
        screen.up()
        projector.off()
        amplifier.off()
        dvdPlayer.stop()
        dvdPlayer.eject()
        dvdPlayer.off()
    }
} 