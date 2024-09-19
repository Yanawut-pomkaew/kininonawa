package com.example.kinino_nawa.service;

import com.example.kinino_nawa.dto.BookBean;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Transactional
    public BookBean getBookAll(BookBean req) {
        BookBean bean = new BookBean();
        bean.setBookName(req.getBookName());
        bean.setAuthor("ICW2");
        return bean;
    }
}
