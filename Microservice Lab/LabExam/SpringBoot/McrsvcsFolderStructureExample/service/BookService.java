package com.example.BookCrud.service;

import com.example.BookCrud.model.Book;
import com.example.BookCrud.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(String bookID) {
        return bookRepository.findById(bookID).orElse(null);
    }


    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void delete(String bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book update(Book book, String bookId) {
        Book book1 = bookRepository.findById(bookId).get();
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());
        bookRepository.save(book1);
        return book1;
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
