package com.ramalt.booksapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ramalt.booksapi.domain.Book;
import com.ramalt.booksapi.domain.BooksEntity;
import com.ramalt.booksapi.repositories.BookRepository;
import com.ramalt.booksapi.services.BookService;

import lombok.NonNull;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(final Book book) {

        final BooksEntity bookEntity = bookToBooksEntity(book);

        final BooksEntity saved = bookRepository.save(bookEntity);
        return BooksEntityToBook(saved);

    }

    @Override
    public List<Book> getBooks() {
        final List<BooksEntity> books = bookRepository.findAll();

        return books.stream()
                .map(this::BooksEntityToBook)
                .collect((Collectors.toList()));

    }

    @Override
    public Optional<Book> GetBookById(@NonNull String id) {
        final Optional<BooksEntity> booksEntity = bookRepository.findById(id);

        return booksEntity.map(book -> BooksEntityToBook(book));

    }

    private BooksEntity bookToBooksEntity(Book book) {
        return BooksEntity.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    private Book BooksEntityToBook(BooksEntity booksEntity) {
        return Book.builder()
                .isbn(booksEntity.getIsbn())
                .title(booksEntity.getTitle())
                .author(booksEntity.getAuthor())
                .build();
    }

}
