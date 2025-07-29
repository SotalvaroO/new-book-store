package com.book.store.application.service;

import java.util.List;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.application.dto.UpdateBook;

public interface BookService {
    List<BookResponse> findAllBooks();

    BookResponse findBookByIsbn(String isbn);

    BookResponse createBook(CreateBook createBook);

    void updateBook(String isbn, UpdateBook updateBook);

    void deleteBookByIsbn(String isbn);
}
