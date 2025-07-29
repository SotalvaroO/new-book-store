package com.book.store.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.book.store.domain.entity.Book;
import com.book.store.infrastructure.entity.BookEntity;

@Component
public class BookInfraMapper {

    public Book infraToDomain(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .isbn(bookEntity.getIsbn())
                .author(bookEntity.getAuthor())
                .publicationYear(bookEntity.getPublicationYear())
                .build();
    }

    public BookEntity domainToInfra(Book book) {
        return BookEntity.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .build();
    }

}
