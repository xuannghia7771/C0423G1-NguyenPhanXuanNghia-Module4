package com.example.book_management.service;

import com.example.book_management.model.BorrowDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowService {
    Page<BorrowDetail> searchByCode(Pageable pageable, String represent);
}
