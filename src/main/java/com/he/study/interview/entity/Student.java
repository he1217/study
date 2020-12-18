package com.he.study.interview.entity;

import lombok.Data;

@Data
public class Student {
    public Student(String name){
        this.name = name;
    }
    private String name;


}
