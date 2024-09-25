package com.example.kinino_nawa;

import com.example.kinino_nawa.dto.BookBean;
import com.example.kinino_nawa.entity.BookEntity;
import com.example.kinino_nawa.repository.BookRepository;
import com.example.kinino_nawa.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository);
    }


    @Test
    void canGetAllBooks() {

        //given
        BookBean bean = new BookBean();

        // when
        bookService.getBookAll(bean);


        // then
        verify(bookRepository).findAll();

    }


    @Test
    void canAddBook() {

        //given
        BookEntity entity = new BookEntity();
        entity.setBookName("A");


        // when
        bookService.addBook(entity);

        // then
        ArgumentCaptor<BookEntity> bookEntityArgumentCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(bookRepository).save(bookEntityArgumentCaptor.capture());

        BookEntity capturedBook =  bookEntityArgumentCaptor.getValue();

        assertThat(capturedBook).isEqualTo(entity);

    }

    @Test
    void canDeleteBookById() {

        //given
        BookEntity entity = new BookEntity();
        entity.setBookName("A");

        // when
        bookService.addBook(entity);
        BookBean bean = new BookBean();
        bean.setBookRef(any());
        bookService.deleteBook(bean);

        // then
        verify(bookRepository).deleteById(any());

    }
}
