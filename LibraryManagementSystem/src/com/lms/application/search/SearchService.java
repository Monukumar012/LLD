package com.lms.application.search;

import com.lms.application.dto.BookSearchResultDTO;

import java.util.List;

public interface SearchService {
    List<BookSearchResultDTO> search(String query, SearchStrategy searchStrategy);
}
