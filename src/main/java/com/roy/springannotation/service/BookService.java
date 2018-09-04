package com.roy.springannotation.service;

import com.roy.springannotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Qualifier("bookDao") //可以指定需要装配组件的名称
    @Autowired(required = false) //存在就装配，不存在就不装配，不会报错
    BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
