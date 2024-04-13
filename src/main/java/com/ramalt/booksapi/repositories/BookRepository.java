package com.ramalt.booksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ramalt.booksapi.domain.BooksEntity;


@Repository
public interface BookRepository extends JpaRepository<BooksEntity, String> {

}
