package com.book.store.application.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationYear;
}
