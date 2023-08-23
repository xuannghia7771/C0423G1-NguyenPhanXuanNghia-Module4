package com.example.user_management.service;

import com.example.user_management.model.User;
import com.example.user_management.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> searchByLastName(Pageable pageable, String searchLastName) {
        return userRepository.findUserByLastNameContaining(pageable,searchLastName);
    }
//    int id, String firstName, String lastName, String phoneNumber, int age, String email
    @Override
    public void add(User user) {
        userRepository.saveNewUser(user.getFirstName(),user.getLastName(),user.getPhoneNumber(),user.getAge(),user.getEmail());
    }
}
