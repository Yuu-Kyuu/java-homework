package com.java.homework.homework02.entity;


import org.springframework.stereotype.Component;

@Component
public class AnnotationBean {

    private String beanProperty;

    public AnnotationBean() {
        this.beanProperty = "annotation injection";
    }

    public String getBeanProperty() {
        return beanProperty;
    }
}
