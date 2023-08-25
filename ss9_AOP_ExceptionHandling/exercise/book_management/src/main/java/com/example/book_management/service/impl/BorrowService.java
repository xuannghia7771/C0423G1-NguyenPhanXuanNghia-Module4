package com.example.book_management.service.impl;

import com.example.book_management.model.BorrowDetail;
import com.example.book_management.repository.IBookRepository;
import com.example.book_management.repository.IBorrowRepository;
import com.example.book_management.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public Page<BorrowDetail> searchByCode(Pageable pageable, String represent) {
        return borrowRepository.searchBorrowDetailByCodeContaining(pageable,represent);
    }
}
