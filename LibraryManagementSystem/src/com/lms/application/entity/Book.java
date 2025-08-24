package com.lms.application.entity;

import java.util.Objects;

public class Book {
    private Long bookId;
    private String bookName;
    private String authorName;
    private Long isinNumber;

    private static Long counter = 50000L;
    public Book() {
        bookId = counter++;
    }

    public Book(Long isinNumber, String bookName, String authorName) {
        this();
        this.isinNumber = isinNumber;
        this.authorName = authorName;
        this.bookName = bookName;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getIsinNumber() {
        return isinNumber;
    }

    public void setIsinNumber(Long isinNumber) {
        this.isinNumber = isinNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", isinNumber=" + isinNumber +
                '}';
    }
}
