package com.lms.application.service;

import com.lms.application.entity.BookCopy;

public interface BookCopyService {
    boolean addBookCopy(BookCopy bookCopy);
    Long getAvailableBookCopyCount(Long bookId);

    BookCopy find(Long bookCopyId);

    BookCopy getAnyAvailableBookCopyByBookId(Long bookId);
}
