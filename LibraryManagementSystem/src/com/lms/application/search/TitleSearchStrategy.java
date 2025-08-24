package com.lms.application.search;

import com.lms.application.entity.Book;
import com.lms.application.service.BookService;

import java.util.List;

public class TitleSearchStrategy implements SearchStrategy{
    private BookService bookService;

    public TitleSearchStrategy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> search(String query) {
        return bookService.searchBookByTitle(query);
    }
}
