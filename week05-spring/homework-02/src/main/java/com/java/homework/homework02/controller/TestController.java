package com.java.homework.homework02.controller;

import com.java.homework.homework02.entity.AnnotationBean;
import com.java.homework.homework02.entity.ConfBean;
import com.java.homework.homework02.entity.XmlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    AnnotationBean annotationBean;

    @Autowired
    ConfBean confBean;

    @Autowired
    XmlBean xmlBean;


    @GetMapping("/annotationBean")
    public String getAnnotationBean() {
        return annotationBean.getBeanProperty();
    }

    @GetMapping("/confBean")
    public String getConfBean() {
        return confBean.getBeanProperty();
    }

    @GetMapping("/xmlBean")
    public String getXmlBean() {
        return xmlBean.getBeanProperty();
    }

}
