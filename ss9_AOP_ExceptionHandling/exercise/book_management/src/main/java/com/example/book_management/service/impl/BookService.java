package com.example.book_management.service.impl;

import com.example.book_management.repository.IBookRepository;
import com.example.book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
}
