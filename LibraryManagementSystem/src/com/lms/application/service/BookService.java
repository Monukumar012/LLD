package com.lms.application.service;

import com.lms.application.entity.Book;

import java.util.List;

public interface BookService {
    boolean addBook(Book book);
    List<Book> searchBookByTitle(String title);
    List<Book> searchBookByAuthor(String author);
}
