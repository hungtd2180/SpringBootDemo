package com.example.springbootdemo.respositories;

import com.example.springbootdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "Select * from user where email = :email", nativeQuery = true)
    User getUserByEmailAbc(String email);
}

/**
 * Sử dụng annotation @Repository để đánh dấu đây là một repository.
 *
 * Kế thừa JpaRepository để sử dụng các phương thức CRUD cơ bản.
 * Các phương thức CRUD cơ bản của JpaRepository:
 * Sau khi kế thừa JpaRepository, chúng ta có thể sử dụng các phương thức CRUD cơ bản như:
 * save(), delete(), findById(), findAll().
 *
 * Hoặc có thể sử dụng các phương thức phù hợp bằng cách chỉ định tên phương thức.
 *
 * Hoặc có thể sử dụng các câu lệnh native query.
 * - Đối với native có hai cách truyền tham số:
    * 1. Sử dụng ?số thứ tự tham số
    * 2. Sử dụng :tên tham số
 *
 */
