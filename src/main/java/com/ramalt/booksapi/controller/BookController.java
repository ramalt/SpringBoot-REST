package com.ramalt.booksapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramalt.booksapi.domain.Book;
import com.ramalt.booksapi.services.impl.BookServiceImpl;

import lombok.NonNull;

@Controller
public class BookController {

    private final BookServiceImpl bookService;

    @Autowired
    public BookController(final BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        final Book saved = bookService.create(book);

        final ResponseEntity<Book> response = new ResponseEntity<Book>(saved, HttpStatus.CREATED);

        return response;
    }

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks() {
        final List<Book> books = bookService.getBooks();

        final ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        return response;
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable @NonNull String id) {
        final Optional<Book> books = bookService.GetBookById(id);

        final ResponseEntity<Optional<Book>> response = new ResponseEntity<Optional<Book>>(books, HttpStatus.OK);
        return response;
    }

}
