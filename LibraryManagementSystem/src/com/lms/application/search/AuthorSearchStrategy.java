package com.lms.application.search;

import com.lms.application.entity.Book;
import com.lms.application.service.BookService;

import java.util.List;

public class AuthorSearchStrategy implements SearchStrategy{
    private BookService bookService;

    public AuthorSearchStrategy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> search(String query) {
        return bookService.searchBookByAuthor(query);
    }
}
