package com.book.store.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBook {
    @NotNull(message = "Title must not be null")
    @NotBlank(message = "Title must have a value")
    private String title;
    @NotNull(message = "Author must not be null")
    @NotBlank(message = "Author must have a value")
    private String author;
    @NotNull(message = "ISBN must not be null")
    @NotBlank(message = "ISBN must have a value")
    private String isbn;
    private LocalDate publicationYear;
}
