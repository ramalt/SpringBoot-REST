package com.ramalt.booksapi.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ramalt.booksapi.domain.Book;
import com.ramalt.booksapi.domain.BooksEntity;
import com.ramalt.booksapi.repositories.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BooksServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatBookIsSaved() {

        final Book book = Book.builder()
                .isbn("12341234")
                .author("Mustafa Kemal Atatürk")
                .title("Nutuk")
                .build();

        final BooksEntity bookEntity = BooksEntity.builder()
                .isbn("12341234")
                .author("Mustafa Kemal Atatürk")
                .title("Nutuk")
                .build();

        when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

        final Book result = underTest.create(book);

        assertEquals(book, result);

    }

}
