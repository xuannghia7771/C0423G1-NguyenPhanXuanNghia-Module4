package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.model.BorrowDetail;
import com.example.book_management.service.IBookService;
import com.example.book_management.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowService borrowService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "",required = false) String represent){
        Pageable pageable = PageRequest.of(page,2);
        Page<Book> bookPage = bookService.searchByName(pageable,represent);
        model.addAttribute("bookPage",bookPage);
        return "list";
    }
    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable int id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }
    @GetMapping("borrowList")
    public String showBorrow(@RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "", required = false) String represent, Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<BorrowDetail> borrowDetailPage = borrowService.searchByCode(pageable, represent);
        model.addAttribute("borrowPage", borrowDetailPage);
        return "borrow-detail";
    }
}
