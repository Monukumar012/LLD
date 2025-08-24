package com.lms.application.service;

import com.lms.application.entity.BookCopy;
import com.lms.application.entity.BookLending;
import com.lms.application.entity.User;

public interface BookLendingService {
    BookLending checkoutBook(Long userId, Long bookCopyId);
    void returnBook(Long checkoutId);
    void returnBook(Long userId, Long bookCopyId);
}
