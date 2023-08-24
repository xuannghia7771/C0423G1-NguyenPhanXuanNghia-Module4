package com.example.book_management.service.impl;

import com.example.book_management.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService implements IReaderService {
    @Autowired
    private IReaderService readerService;
}
