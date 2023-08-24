package com.example.book_management.repository;

import com.example.book_management.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReaderRepository extends JpaRepository<Reader, Integer> {
}
