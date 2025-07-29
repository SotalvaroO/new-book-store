package com.book.store.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 150)
    private String author;
    @Column(name = "publication_year", nullable = true)
    private LocalDate publicationYear;
}
