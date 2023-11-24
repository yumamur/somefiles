package com.yumamur.firstapidb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "human")
public class Human {
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Human(int age) {
        this.age = age;
    }

    public Human() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
