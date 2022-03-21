package com.recipeapp.recipe.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;



@Entity
@Table(name = "Profiles")

@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long      id;

    private String        name;
    @Column(nullable = false, unique = true)

    private String        email;
    @Column(unique = true, updatable = false)

    private String        username;

    @Column(nullable = false, unique = true)
    private String        mobile;









}
