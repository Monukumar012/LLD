package com.lms.application.search;

import com.lms.application.dto.BookSearchResultDTO;
import com.lms.application.entity.Book;
import com.lms.application.service.BookCopyService;
import java.util.List;

public class SearchServiceImpl implements SearchService{
    private final BookCopyService bookCopyService;

    // Singleton with DI
    private static SearchService INSTANCE;

    public static SearchService getInstance(BookCopyService bookCopyService) {
        if (INSTANCE == null) {
            INSTANCE = new SearchServiceImpl(bookCopyService);
        }
        return INSTANCE;
    }

    public SearchServiceImpl(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    public List<BookSearchResultDTO> search(String query, SearchStrategy searchStrategy){
        List<Book> searchResult = searchStrategy.search(query);
        return searchResult.stream().map(this::getBookResultDTO).toList();
    }

    private BookSearchResultDTO getBookResultDTO(Book book) {
        BookSearchResultDTO bookSearchResultDTO = new BookSearchResultDTO();
        bookSearchResultDTO.setBookId(book.getBookId());
        bookSearchResultDTO.setBookName(book.getBookName());
        bookSearchResultDTO.setAuthorName(book.getAuthorName());
        bookSearchResultDTO.setAvailableCopyCount(bookCopyService.getAvailableBookCopyCount(book.getBookId()));
        return bookSearchResultDTO;
    }
}
