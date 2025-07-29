package com.book.store.application.mapper;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.domain.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookResponse bookToBookResponse(Book book) {
        return BookResponse.builder()
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .build();
    }

    @Override
    public Book createBookToBook(CreateBook createBook) {
        return Book.builder()
                .title(createBook.getTitle())
                .isbn(createBook.getIsbn())
                .author(createBook.getAuthor())
                .publicationYear(createBook.getPublicationYear())
                .build();
    }
}
