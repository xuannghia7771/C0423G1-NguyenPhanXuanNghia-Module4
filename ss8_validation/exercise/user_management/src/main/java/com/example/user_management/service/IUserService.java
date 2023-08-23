package com.example.user_management.service;

import com.example.user_management.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> searchByLastName(Pageable pageable, String searchLastName);

    void add(User user);
}
