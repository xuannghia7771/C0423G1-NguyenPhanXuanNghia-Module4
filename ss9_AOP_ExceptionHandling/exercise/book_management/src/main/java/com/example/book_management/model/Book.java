package com.example.book_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<BorrowDetail> borrowDetailSet;

    public Book() {

    }

    public Book(int bookId, String bookName, int quantity, Set<BorrowDetail> borrowDetailSet) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.borrowDetailSet = borrowDetailSet;
    }

    public Book(int bookId, String bookName, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowDetail> getBorrowDetailSet() {
        return borrowDetailSet;
    }

    public void setBorrowDetailSet(Set<BorrowDetail> borrowDetailSet) {
        this.borrowDetailSet = borrowDetailSet;
    }
}
