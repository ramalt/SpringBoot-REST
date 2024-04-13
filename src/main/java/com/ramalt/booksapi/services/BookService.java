package com.ramalt.booksapi.services;

import java.util.List;
import java.util.Optional;

import com.ramalt.booksapi.domain.Book;

public interface BookService {

    Book create(Book book);

    List<Book> getBooks();

    // Book GetBookByIsbn(String isbn);

    Optional<Book> GetBookById(String id);

}
