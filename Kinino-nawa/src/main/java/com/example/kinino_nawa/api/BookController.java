package com.example.kinino_nawa.api;

import com.example.kinino_nawa.dto.BookBean;
import com.example.kinino_nawa.entity.BookEntity;
import com.example.kinino_nawa.service.BookService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@Configuration
@RequestMapping("books")
public class BookController implements WebMvcConfigurer {

    @PersistenceContext
    private EntityManager entityManager;

    private final BookService bookService;

    String a = "2";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("getAllBooks")
    public List<BookEntity> getAllBooks(@RequestBody BookBean req ) {

        return bookService.getBookAll(req);


    }

    @PostMapping("getBookById")
    public BookEntity getBookById(@RequestBody BookBean req ) {
        return bookService.getBookById(req);
    }

    @PostMapping("addBook")
    public BookEntity addBook(@RequestBody BookEntity req ) {
        return bookService.addBook(req);
    }

    @PostMapping("deleteBook")
    public void deleteBook(@RequestBody BookBean req ) {
        bookService.deleteBook(req);
    }





}
