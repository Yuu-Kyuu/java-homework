package com.java.homework.weekseven.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    @Pointcut("@annotation(com.java.homework.weekseven.component.RWDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        RWDataSource rwDataSource = method.getAnnotation(RWDataSource.class);
        if (rwDataSource == null) {
            ReadWriteDataSource.setDataSource(ReadWriteDataSource.READ_DATASOURCE);
            log.debug("set datasource is " + ReadWriteDataSource.READ_DATASOURCE);
        } else {
            ReadWriteDataSource.setDataSource(rwDataSource.name());
            log.debug("set datasource is " + rwDataSource.name());
        }

        try {
            return point.proceed();
        } finally {
            ReadWriteDataSource.clearDataSource();
            log.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}