package com.example.springbootdemo.controllers;


import com.example.springbootdemo.models.Post;
import com.example.springbootdemo.models.User;
import com.example.springbootdemo.servies.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value="/users")
    public ResponseEntity<?> getUser() {
        Optional<User> user = userService.findById(1L);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value="/users/{id}") // path variable
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/users") // request param
    public ResponseEntity<?> deleteUser2(@RequestParam("id") Long userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        Post post = new Post();
        post.setTitle("title");
        post.setUser(user);
        user.setPost(post);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value="/users")
    public ResponseEntity<?> updateUser(@ModelAttribute User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

/*
 * Sử dụng annotation @Controller hoặc @RestController để đánh dấu đây là một controller.
 * Sử dụng các annotation @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
 * để đánh dấu các phương thức tương ứng với các phương thức HTTP.
 * Thứ 3 là inject các service vào controller bằng annotation @Autowired hoặc sử dụng constructor.
 * Có các kiểu truyền tham số request như sau:
 * 1. @PathVariable: truyền tham số trên URL. Ví dụ: /users/{id} // id là tham số trên URL
 * 2. @RequestParam: truyền tham số trên URL. Ví dụ: /users?id=1 // id là tham số trên URL
 * 3. @RequestBody: truyền tham số trong body của request. Ví dụ: /users // tham số truyền trong body của request
 * 4. @ModelAttribute: truyền tham số trong body của request. Ví dụ: /users // tham số truyền trong body của request
 */