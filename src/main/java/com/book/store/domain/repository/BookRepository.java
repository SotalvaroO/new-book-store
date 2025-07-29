package com.book.store.domain.repository;

import com.book.store.domain.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    Book save(Book entity);

    List<Book> findAll();

    Optional<Book> findById(UUID id);

    void deleteById(UUID id);

    Optional<Book> findByIsbn(String isbn);

    Optional<Book> deleteByIsbn(String isbn);

}
