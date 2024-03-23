package com.example.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope()
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 225, nullable = false, unique = true)
    private String username;
    private String password;
}
