package com.book.store.application.service;

import com.book.store.application.dto.BookResponse;
import com.book.store.application.dto.CreateBook;
import com.book.store.application.dto.UpdateBook;
import com.book.store.application.mapper.BookMapper;
import com.book.store.domain.entity.Book;
import com.book.store.domain.exception.BookNotFoundException;
import com.book.store.domain.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponse> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(bookMapper::bookToBookResponse)
                .orElseThrow(() -> {
                            log.error("Book with isbn {} not found", isbn);
                            return new BookNotFoundException(
                                    String.format("Book with isbn %s not found", isbn)
                            );
                        }
                );
    }

    @Override
    public BookResponse createBook(CreateBook createBook) {
        Book book = bookMapper.createBookToBook(createBook);
        book.initialize();
        return bookMapper.bookToBookResponse(bookRepository.save(book));
    }

    @Override
    public void updateBook(String isbn, UpdateBook updateBook) {
        Book existingBook = bookRepository.findByIsbn(isbn).orElseThrow(
                () -> {
                    log.error("Book with isbn {} not found", isbn);
                    return new BookNotFoundException(
                            String.format("Book with isbn %s not found", isbn)
                    );
                }
        );
        existingBook.setAuthor(updateBook.getAuthor());
        existingBook.setTitle(updateBook.getTitle());
        existingBook.setPublicationYear(updateBook.getPublicationYear());
        existingBook.setIsbn(isbn);
        bookRepository.save(existingBook);
    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        bookRepository.deleteByIsbn(isbn).orElseThrow(() -> {
            log.error("Book with isbn {} not found", isbn);
            return new BookNotFoundException(
                    String.format("Book with isbn %s not found", isbn)
            );
        });
    }
}
