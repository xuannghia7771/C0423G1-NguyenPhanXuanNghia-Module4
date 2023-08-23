package com.example.user_management.repository;

import com.example.user_management.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Page<User> findUserByLastNameContaining(Pageable pageable, String searchLastName);

    @Modifying
    @Transactional
    @Query(value = "insert into `user`(user_first_name,user_last_name,user_phone_number,user_age,user_email) " +
            "values (:firstName,:lastName,:phoneNumber,:age,:email)",nativeQuery = true)
    void saveNewUser(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("phoneNumber") String phoneNumber,
                     @Param("age") int age,@Param("email") String email);
}
