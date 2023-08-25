package com.example.book_management.service.impl;

import com.example.book_management.model.Book;
import com.example.book_management.repository.IBookRepository;
import com.example.book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> searchByName(Pageable pageable, String represent) {
        return bookRepository.findBookByNameContaining(pageable,represent);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
