package com.example.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Builder
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
