package com.java.homework.homework08.starter.entity;

import lombok.Data;
import java.util.List;

@Data
public class Klass {

    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
