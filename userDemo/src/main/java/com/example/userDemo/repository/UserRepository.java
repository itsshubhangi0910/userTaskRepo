package com.example.userDemo.repository;

import com.example.userDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM `user` WHERE email LIKE %:email%",nativeQuery = true)
    List<User> getEmail(String email);

    @Query(value = "SELECT * FROM `user` WHERE name LIKE %:name%",nativeQuery = true)
    List<User> getName(String name);

    @Query(value = "SELECT * FROM `user` WHERE zip_code LIKE %:zipCode%",nativeQuery = true)
    List<User> getZipCode(String zipCode);

    @Query(value = "SELECT email AS email,name AS name,zip_code AS zipCode",nativeQuery = true)
    List<User> getAllEmailAndNameAndZipCode(String email, String name, String zipCode);

    boolean existsByEmailAndUserIdNotIn(String email, List<Long> userIds);
}
