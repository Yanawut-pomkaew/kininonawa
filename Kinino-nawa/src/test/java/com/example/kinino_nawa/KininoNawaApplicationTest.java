package com.example.kinino_nawa;

import com.example.kinino_nawa.entity.BookEntity;
import com.example.kinino_nawa.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class KininoNawaApplicationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void mainTest() {
        String doneJob = "TESTING ARE WORKING";
        assertEquals("TESTING ARE WORKING" , doneJob);
    }

    @Test
    void BookRepository_findAll() {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("AA");
        bookRepository.save(bookEntity);
        List<BookEntity> allBooks = bookRepository.findAll();
        Assertions.assertEquals(1, allBooks.size());

    }

    @Test
    void BookRepository_findById_and_save() {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("AA");
        BookEntity savedBook = bookRepository.save(bookEntity);
        BookEntity selectedBook = bookRepository.findById(savedBook.getBookRef()).orElse(null);
        Assertions.assertNotNull(selectedBook);

    }

    @Test
    void BookRepository_deleteById() {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("AA");
        BookEntity savedBook = bookRepository.save(bookEntity);

        BookEntity selectedBook = bookRepository.findById(savedBook.getBookRef()).orElse(null);

        Assertions.assertNotNull(selectedBook);

        bookRepository.deleteById(savedBook.getBookRef());

        BookEntity selectedBookAgain = bookRepository.findById(savedBook.getBookRef()).orElse(null);

        Assertions.assertNull(selectedBookAgain);

    }

}