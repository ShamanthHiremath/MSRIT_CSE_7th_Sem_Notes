package com.example.BookCrud.controller;

import com.example.BookCrud.model.Book;
import com.example.BookCrud.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{bookID}")
    public Book getBook(@PathVariable String bookID) {
        return bookService.getBook(bookID);
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        bookService.delete(bookId);
        return "Employee Deleted";
    }

    @PutMapping("/updateBook/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable String bookId) {
        return bookService.update(book, bookId);
    }

    @DeleteMapping("/deleteAll")
    public String deleteBooks() {
        bookService.deleteAll();
        return "All Emplyees data deleted";
    }
}
