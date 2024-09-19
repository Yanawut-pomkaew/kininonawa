package com.example.kinino_nawa.api;

import com.example.kinino_nawa.dto.BookBean;
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
public class BookController implements WebMvcConfigurer {

    @PersistenceContext
    private EntityManager entityManager;

    private final BookService bookService;

    String a = "2";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("hello")
    public BookBean helloWorld(@RequestBody BookBean req ) {
        BookBean bean = new BookBean();
        bean.setBookName(req.getBookName());

        return bookService.getBookAll(bean);

    }

}
