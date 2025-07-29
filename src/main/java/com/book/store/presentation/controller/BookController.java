package com.book.store.presentation.controller;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.application.dto.UpdateBook;
import com.book.store.application.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping(value = "{isbn}")
    public ResponseEntity<BookResponse> findBookByIsbn(@PathVariable("isbn") String isbn) {
        return ResponseEntity.ok(bookService.findBookByIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody @Valid CreateBook createBook) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(createBook));
    }

    @PutMapping(value = "{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable("isbn") String isbn, @RequestBody @Valid UpdateBook updateBook) {
        bookService.updateBook(isbn, updateBook);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBookByIsbn(isbn);
        return ResponseEntity.noContent().build();
    }
}
