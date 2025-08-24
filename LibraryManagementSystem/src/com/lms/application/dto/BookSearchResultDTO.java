package com.lms.application.dto;

public class BookSearchResultDTO {
    private Long bookId;
    private String bookName;
    private String authorName;
    private Long availableCopyCount;

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

    public Long getAvailableCopyCount() {
        return availableCopyCount;
    }

    public void setAvailableCopyCount(Long availableCopyCount) {
        this.availableCopyCount = availableCopyCount;
    }

    @Override
    public String toString() {
        return "BookSearchResultDTO{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", availableCopyCount=" + availableCopyCount +
                '}';
    }
}
