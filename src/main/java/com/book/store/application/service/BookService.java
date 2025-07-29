package com.book.store.application.service;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.application.dto.UpdateBook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    List<BookResponse> findAllBooks();

    BookResponse findBookByIsbn(String isbn);

    BookResponse createBook(CreateBook createBook);

    void updateBook(String isbn, UpdateBook updateBook);

    void deleteBookByIsbn(String isbn);
}
