package com.ramalt.booksapi.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class Book {

    private String isbn;

    private String author;
    
    private String title;
    
}
