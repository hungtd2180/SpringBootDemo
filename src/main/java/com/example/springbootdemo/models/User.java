package com.example.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Post post;
}
