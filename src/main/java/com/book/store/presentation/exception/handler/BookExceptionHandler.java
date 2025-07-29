package com.book.store.presentation.exception.handler;

import com.book.store.application.dto.ErrorDto;
import com.book.store.domain.exception.BookDomainException;
import com.book.store.domain.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class BookExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = {BookNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleBookNotFoundException(BookNotFoundException ex) {
        return ErrorDto.builder()
                .code("404")
                .message(ex.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return errors;
    }

    @ResponseBody
    @ExceptionHandler(value = {BookDomainException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleBookDomainException(BookNotFoundException ex) {
        return ErrorDto.builder()
                .code("404")
                .message(ex.getMessage())
                .build();
    }
}
