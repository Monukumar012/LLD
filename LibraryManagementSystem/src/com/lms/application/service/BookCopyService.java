package com.lms.application.service;

import com.lms.application.entity.BookCopy;

public interface BookCopyService {
    boolean addBookCopy(BookCopy bookCopy);
    Long getBookCopyCount(Long bookId);

    BookCopy find(Long bookCopyId);
}
