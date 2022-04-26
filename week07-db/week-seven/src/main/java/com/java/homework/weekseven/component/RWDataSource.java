package com.java.homework.weekseven.component;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RWDataSource {

    String name() default ReadWriteDataSource.READ_DATASOURCE;

}