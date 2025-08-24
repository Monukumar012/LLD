package com.lms.application.service;

import com.lms.application.entity.BookCopy;

import java.util.HashMap;
import java.util.Map;

public class BookCopyServiceImpl implements BookCopyService{
    private final Map<Long, BookCopy> bookCopies;


    // Get Singleton Instance
    public static BookCopyService getInstance(){
        return BookCopyServiceImpl.BookCopyServiceInstance.INSTANCE;
    }
    private static class BookCopyServiceInstance{
        private static final BookCopyService INSTANCE = new BookCopyServiceImpl();
    }

    public boolean addBookCopy(BookCopy bookCopy){
        if(bookCopy == null){
            throw new RuntimeException("BookCopy Entity can't be null");
        }
        return bookCopies.put(bookCopy.getBookCopyId(), bookCopy) != null;
    }

    public Long getBookCopyCount(Long bookId){
        return bookCopies.values().stream()
                .filter(bookCopy -> bookId.equals(bookCopy.getBookId())).count();
    }

    @Override
    public BookCopy find(Long bookCopyId) {
        BookCopy bookCopy = bookCopies.get(bookCopyId);
        if(bookCopy == null){
            throw new RuntimeException("Entity not found with id : "+bookCopyId);
        }
        return bookCopy;
    }

    {
        bookCopies = new HashMap<>();
    }
}
