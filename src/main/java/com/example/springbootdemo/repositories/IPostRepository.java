package com.example.springbootdemo.repositories;

import com.example.springbootdemo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

}
