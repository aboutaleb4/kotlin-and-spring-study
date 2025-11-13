package com.example.controller

import com.example.graphqldemo.model.Book
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {

    private val books = listOf(
        Book(1, "The Hobbit", "J.R.R. Tolkien"),
        Book(2, "1984", "George Orwell"),
        Book(3, "Clean Code", "Robert C. Martin")
    )

    @QueryMapping
    fun books(): List<Book> = books
}