package com.example.book_management.service;

import com.example.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> searchByName(Pageable pageable, String represent);

    Book findById(int id);
}
