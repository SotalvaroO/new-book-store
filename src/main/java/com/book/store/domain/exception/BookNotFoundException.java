package com.book.store.domain.exception;

public class BookNotFoundException extends BookDomainException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
