package com.example.book_management.repository;

import com.example.book_management.model.BorrowDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<BorrowDetail, Integer> {
    Page<BorrowDetail> searchBorrowDetailByCodeContaining(Pageable pageable, String represent);
}
