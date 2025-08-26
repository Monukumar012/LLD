package com.lms.application;

import com.lms.application.dto.BookSearchResultDTO;
import com.lms.application.entity.Book;
import com.lms.application.entity.BookCopy;
import com.lms.application.entity.BookLending;
import com.lms.application.entity.User;
import com.lms.application.enums.BookCondition;
import com.lms.application.enums.BookCopyStatus;
import com.lms.application.search.*;
import com.lms.application.service.*;

import java.util.List;

public class LibraryManagementSystem {
    private BookService bookService;
    private BookCopyService bookCopyService;
    private UserService userService;
    private SearchService searchService;
    private BookLendingService bookLendingService;
    private SearchStrategy titleSearchStrategy;
    private SearchStrategy authorSearchStrategy;



    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.initilize();

        libraryManagementSystem.run();
    }

    public void run(){
        List<BookSearchResultDTO> bookSearchResultDTOS1 = searchService.search("Harry Potter 1", titleSearchStrategy);
        System.out.println(bookSearchResultDTOS1);
        List<BookSearchResultDTO> bookSearchResultDTOS2 = searchService.search("Alex", authorSearchStrategy);
        System.out.println(bookSearchResultDTOS2);

        // Checkout Book
        BookLending bookLending1 = bookLendingService.checkoutBook(5000L, 50000L);
        System.out.println("Book checkout : "+bookLending1);

        // Checkout Book
        BookLending bookLending2 = bookLendingService.checkoutBook(5001L, 50000L);
        System.out.println("Book checkout : "+bookLending2);

        bookSearchResultDTOS1 = searchService.search("Harry Potter 1", titleSearchStrategy);
        System.out.println(bookSearchResultDTOS1);

        // Return Book
        //BookLending afterReturn = bookLendingService.returnBook(10000L);
        BookLending afterReturn = bookLendingService.returnBook(5000L, 10000L);
        System.out.println("After book return : "+afterReturn);

        bookSearchResultDTOS1 = searchService.search("Harry Potter 1", titleSearchStrategy);
        System.out.println(bookSearchResultDTOS1);

        //bookLendingService.checkoutBook()
    }

    private void initilize() {
        initilizeBeans();
        initilizeTestData();
    }

    private void initilizeTestData() {
        Book book1 = new Book(1010L, "Harry Potter 1", "Alex");
        bookService.addBook(book1);
        bookCopyService.addBookCopy(new BookCopy(book1.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book1.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book1.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book1.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));

        Book book2 = new Book(1010L, "Harry Potter 2", "Alex");
        bookService.addBook(book2);
        bookCopyService.addBookCopy(new BookCopy(book2.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book2.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book2.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));

        Book book3 = new Book(1010L, "Harry Potter 3", "Alex");
        bookService.addBook(book3);
        bookCopyService.addBookCopy(new BookCopy(book3.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));

        Book book4 = new Book(1010L, "Brain Hack", "Robbin");
        bookService.addBook(book4);
        bookCopyService.addBookCopy(new BookCopy(book4.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));

        Book book5 = new Book(1010L, "Time Management", "Erik");
        bookService.addBook(book5);
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));
        bookCopyService.addBookCopy(new BookCopy(book5.getBookId(), BookCondition.GOOD, BookCopyStatus.AVAILABLE));

        userService.registerUser(new User(5000L, "Monu Kumar"));
        userService.registerUser(new User(5001L, "Prince Kumar"));
    }

    private void initilizeBeans() {
        bookService = BookServiceImpl.getInstance();
        bookCopyService = BookCopyServiceImpl.getInstance();
        userService = UserServiceImpl.getInstance();
        searchService = SearchServiceImpl.getInstance(bookCopyService);
        bookLendingService = BookLendingServiceImpl.getInstance(bookCopyService, userService);
        titleSearchStrategy = new TitleSearchStrategy(bookService);
        authorSearchStrategy = new AuthorSearchStrategy(bookService);
    }
}
