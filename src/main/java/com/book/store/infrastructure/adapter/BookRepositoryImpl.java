package com.book.store.infrastructure.adapter;

import com.book.store.domain.entity.Book;
import com.book.store.domain.repository.BookRepository;
import com.book.store.infrastructure.datasource.BookJpaRepository;
import com.book.store.infrastructure.entity.BookEntity;
import com.book.store.infrastructure.mapper.BookInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookJpaRepository;
    private final BookInfraMapper bookInfraMapper;

    @Override
    public Book save(Book entity) {
        return bookInfraMapper.infraToDomain(bookJpaRepository.save(bookInfraMapper.domainToInfra(entity)));
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll().stream().map(bookInfraMapper::infraToDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookJpaRepository.findById(id).map(bookInfraMapper::infraToDomain);
    }

    @Override
    public void deleteById(UUID id) {
        bookJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookJpaRepository.findByIsbn(isbn).map(bookInfraMapper::infraToDomain);
    }

    @Override
    public Optional<Book> deleteByIsbn(String isbn) {
        Optional<BookEntity> bookEntity = bookJpaRepository.findByIsbn(isbn);
        bookEntity.ifPresent(book -> bookJpaRepository.deleteById(book.getId()));
        return bookEntity.map(bookInfraMapper::infraToDomain);
    }
}
