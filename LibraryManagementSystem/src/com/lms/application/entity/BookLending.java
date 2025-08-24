package com.lms.application.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class BookLending {
    private Long checkoutId;
    private User user;
    private BookCopy bookCopy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private static Long counter = 10000L;
    public BookLending(){
        checkoutId = counter++;
    }


    public BookLending(BookCopy bookCopy, User user) {
        this();
        this.bookCopy = bookCopy;
        this.user = user;
    }

    public Long getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Long checkoutId) {
        this.checkoutId = checkoutId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookLending bookLending)) return false;
        return Objects.equals(checkoutId, bookLending.checkoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(checkoutId);
    }
}
