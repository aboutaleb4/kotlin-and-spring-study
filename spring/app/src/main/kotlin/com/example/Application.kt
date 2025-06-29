package com.example

import org.h2.tools.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.SQLException

@SpringBootApplication
class Application {

    // This bean starts the H2 TCP server when the application context is refreshed
    @Bean(initMethod = "start", destroyMethod = "stop")
    @Throws(SQLException::class)
    fun h2TcpServer(): Server {
        // You can specify port, allow others, etc.
        // -tcpAllowOthers allows other machines to connect (useful if DataGrip is not on localhost)
        // -tcpPort specifies the port (default is 9092)
        // -tcpAllowOthers - if you use this option, be aware of security implications in production!
        // You might want to remove -tcpAllowOthers or configure proper security for production.
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092")
    }

    // Optional: Event listener to ensure the server stops cleanly on application shutdown
    // The destroyMethod in @Bean annotation usually handles this, but this is an explicit way.
    @EventListener(ContextClosedEvent::class)
    fun stopH2Server(event: ContextClosedEvent) {
        // The stop method is usually handled by the @Bean(destroyMethod="stop")
        // but this shows how you could manually stop it if needed.
        // Server.shutdownTcpServer("tcp://localhost:9092", "", true, true); // For remote shutdown
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@RestController
class HelloController {
    @GetMapping("/")
    fun hello(): String {
        return "Hello, World!!!"
    }
} 