package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany
    private List<Movie> movies;
}
