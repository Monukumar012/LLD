package com.lms.application.entity;

import com.lms.application.enums.BookCondition;
import com.lms.application.enums.BookCopyStatus;

import java.util.Objects;

public class BookCopy {
    private Long bookCopyId;
    private BookCopyStatus bookCopyStatus;
    private BookCondition bookCondition;
    private Long bookId;

    private static Long counter = 10000L;
    public BookCopy(){
        this.bookCopyId = counter++;
    }

    public BookCopy(Long bookId, BookCondition bookCondition, BookCopyStatus bookCopyStatus) {
        this();
        this.bookId = bookId;
        this.bookCondition = bookCondition;
        this.bookCopyStatus = bookCopyStatus;
    }

    public Long getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(Long bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public BookCopyStatus getBookCopyStatus() {
        return bookCopyStatus;
    }

    public void setBookCopyStatus(BookCopyStatus bookCopyStatus) {
        this.bookCopyStatus = bookCopyStatus;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookCopy bookCopy)) return false;
        return Objects.equals(bookCopyId, bookCopy.bookCopyId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookCopyId);
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "bookCopyId=" + bookCopyId +
                ", bookCopyStatus=" + bookCopyStatus +
                ", bookCondition=" + bookCondition +
                ", bookId=" + bookId +
                '}';
    }
}
