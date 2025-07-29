package com.book.store.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Book extends BaseEntity<UUID> {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationYear;

    private Book(Builder builder) {
        super.setId(builder.id);
        title = builder.title;
        author = builder.author;
        isbn = builder.isbn;
        publicationYear = builder.publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void initialize() {
        setId(UUID.randomUUID());
    }


    public static final class Builder {
        private UUID id;
        private String title;
        private String author;
        private String isbn;
        private LocalDate publicationYear;

        private Builder() {
        }

        public Builder id(UUID val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder isbn(String val) {
            isbn = val;
            return this;
        }

        public Builder publicationYear(LocalDate val) {
            publicationYear = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
