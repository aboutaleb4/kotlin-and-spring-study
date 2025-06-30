package com.example.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {
    @Value("\${message}") //Comes from application.yaml --> Good for env based variables
    lateinit var message: String
    fun greeting(name: String) = "$name, $message"
}