package com.book.store.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.application.dto.UpdateBook;
import com.book.store.application.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
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
