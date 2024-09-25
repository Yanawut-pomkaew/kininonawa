package com.example.kinino_nawa.service;

import com.example.kinino_nawa.dto.BookBean;
import com.example.kinino_nawa.entity.BookEntity;
import com.example.kinino_nawa.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Transactional
    public List<BookEntity> getBookAll(BookBean req)  {
        return bookRepository.findAll();

    }

    @Transactional
    public BookEntity getBookById(BookBean req) {
        return bookRepository.findById(req.getBookRef()).orElse(null);

    }


    @Transactional
    public BookEntity addBook(BookEntity req) {
        return bookRepository.save(req);
    }

    @Transactional
    public void deleteBook(BookBean req) {
        bookRepository.deleteById(req.getBookRef());
    }

}
