package com.lms.application.service;

import com.lms.application.entity.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookServiceImpl implements BookService{
    private final Map<Long, Book> books;

    // Get Singleton Instance
    public static BookService getInstance(){
        return BookServiceInstance.INSTANCE;
    }
    private static class BookServiceInstance{
        private static final BookService INSTANCE = new BookServiceImpl();
    }

    public boolean addBook(Book book){
        if(book == null){
            throw new RuntimeException("Book Entity can't be null");
        }
        return books.put(book.getBookId(), book) != null;
    }

    public List<Book> searchBookByTitle(String title){
        return books.values().stream().filter(book -> title.equalsIgnoreCase(book.getBookName())).toList();
    }

    public List<Book> searchBookByAuthor(String author){
        return books.values().stream().filter(book -> author.equalsIgnoreCase(book.getAuthorName())).toList();
    }


    // Pre Construct
    {
        books = new HashMap<>();
    }
}
