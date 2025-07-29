package com.book.store.application.mapper;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.domain.entity.Book;

public interface BookMapper {
    BookResponse bookToBookResponse(Book book);

    Book createBookToBook(CreateBook createBook);
}
