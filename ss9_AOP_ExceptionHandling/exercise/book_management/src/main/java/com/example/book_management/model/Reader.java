package com.example.book_management.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private int readerId;
    @Column(name = "reader_name")
    private String readerName;
    @Column(name = "reader_phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "reader")
    private Set<BorrowDetail> borrowDetailSet;

    public Reader() {

    }

    public Reader(int readerId, String readerName, String phoneNumber, Set<BorrowDetail> borrowDetailSet) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.phoneNumber = phoneNumber;
        this.borrowDetailSet = borrowDetailSet;
    }

    public Reader(int readerId, String readerName, String phoneNumber) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.phoneNumber = phoneNumber;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<BorrowDetail> getBorrowDetailSet() {
        return borrowDetailSet;
    }

    public void setBorrowDetailSet(Set<BorrowDetail> borrowDetailSet) {
        this.borrowDetailSet = borrowDetailSet;
    }
}
