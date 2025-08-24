package com.lms.application.search;

import com.lms.application.entity.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> search(String query);
}
