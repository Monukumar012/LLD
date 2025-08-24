package com.lms.application.service;

import com.lms.application.entity.BookCopy;
import com.lms.application.entity.BookLending;
import com.lms.application.entity.User;
import com.lms.application.enums.BookCopyStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BookLendingServiceImpl implements BookLendingService{
    private final Map<Long, BookLending> bookLendings;
    private final BookCopyService bookCopyService;
    private final UserService userService;

    public BookLendingServiceImpl(BookCopyService bookCopyService, UserService userService) {
        this.bookCopyService = bookCopyService;
        this.userService = userService;
    }

    // Get Singleton Instance
    private static BookLendingService INSTANCE;
    public static BookLendingService getInstance(BookCopyService bookCopyService, UserService userService){
        if(INSTANCE == null){
            INSTANCE = new BookLendingServiceImpl(bookCopyService, userService);
        }
        return INSTANCE;
    }


    public BookLending checkoutBook(Long userId, Long bookCopyId){
        BookCopy bookCopy = bookCopyService.find(bookCopyId);
        if(bookCopy.getBookCopyStatus() == BookCopyStatus.BORROWED){
            throw new RuntimeException("BookCopy is already borrowed : "+bookCopy.getBookCopyId());
        }
        User user = userService.find(userId);
        BookLending bookLending = new BookLending(bookCopy, user);
        bookCopy.setBookCopyStatus(BookCopyStatus.BORROWED);
        bookLending.setStartTime(LocalDateTime.now());
        bookLendings.put(bookLending.getCheckoutId(), bookLending);
        return bookLending;
    }

    public void returnBook(Long checkoutId){
        BookLending bookLending = bookLendings.get(checkoutId);
        if(bookLending != null){
            // set book status as available
            bookLending.getBookCopy().setBookCopyStatus(BookCopyStatus.AVAILABLE);
            bookLending.setEndTime(LocalDateTime.now());
        }
    }

    public void returnBook(Long userId, Long bookCopyId){
        BookLending bookLending1 = bookLendings.values().stream()
                .filter(bookLending -> bookLending.getBookCopy().getBookCopyId().equals(bookCopyId)
                        && bookLending.getUser().getUserId().equals(userId)).findFirst().orElse(null);
        if(bookLending1 != null){
            // set book status as available
            bookLending1.getBookCopy().setBookCopyStatus(BookCopyStatus.AVAILABLE);
            bookLending1.setEndTime(LocalDateTime.now());
        }
    }

    {
        bookLendings = new HashMap<>();
    }
}
