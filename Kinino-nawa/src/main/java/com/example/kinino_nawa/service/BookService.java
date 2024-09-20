package com.example.kinino_nawa.service;

import com.example.kinino_nawa.dto.BookBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @SuppressWarnings("unchecked")
    public List<BookBean> getBookAll(BookBean req)  {

        List<Tuple>  result = entityManager.createNativeQuery("SELECT bookName, totalPage , amount from book" , Tuple.class)
                .getResultList();


        if(result.isEmpty()) {
            return null;
        } else {
        List<BookBean> resultLists = new ArrayList<>();
            for (int i = 0 ; i < result.size() ; ++i) {

                Tuple tuple = result.get(i);

                BookBean bean = new BookBean();
                bean.setBookName(tuple.get("bookName", String.class));
                bean.setTotalPage(parseLong(tuple.get("totalPage", String.class)));
                bean.setAmount(tuple.get("amount", Integer.class));

                resultLists.add(bean);

            }

            return resultLists;
        }



    }
}
